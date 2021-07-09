/**
 * 
 */
package com.gss.pulseworkflow.oauth;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;

import javax.net.ssl.SSLContext;
import javax.servlet.Filter;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.exception.ErrorHandler;
import com.gss.pulseworkflow.oauth.filter.PulseAccessDeninedHandler;
import com.gss.pulseworkflow.oauth.filter.PulseAccessTokenFilter;
import com.gss.pulseworkflow.oauth.filter.PulseAuthenticationEntryPoint;
import com.gss.pulseworkflow.oauth.filter.PulseAuthenticationManager;
import com.gss.pulseworkflow.oauth.filter.PulseLoginFilter;
import com.gss.pulseworkflow.oauth.filter.PulseLogoutHandler;
import com.gss.pulseworkflow.oauth.filter.PulseTokenCheckerFilter;
import com.gss.pulseworkflow.oauth.service.PulseUserDetailService;

/**
 * @author SAURABH
 *
 */
@Configuration
@EnableWebSecurity
public class OauthConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${external.wso2.user.service.endpoint}")
    private String wsoEndPoint;
    
    @Value("${external.wso2.username}")
    private String wso2Username;
    
    @Value("${external.wso2.password}")
    private String wso2Password;
    
    @Bean
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public HandlerExceptionResolver exceptionHandler() {
        return new ErrorHandler();
    }

    @Bean
    public Filter loginFilter() {
        return new PulseLoginFilter(new AntPathRequestMatcher("/oauth/login", HttpMethod.GET.toString()));
    }

    @Bean
    public Filter authenticationFilter() throws Exception {
        PulseAccessTokenFilter filter = new PulseAccessTokenFilter(
                new AntPathRequestMatcher("/oauth/accessToken", HttpMethod.POST.toString()));
        filter.setAuthenticationManager(getAuthenticationManager());
        return filter;
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new PulseAuthenticationEntryPoint();
    }

    @Bean
    public Filter tokenCheckerFilter() {
        return new PulseTokenCheckerFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().and().csrf().disable().cors().configurationSource(corsConfigurationSource()).and()
                .addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(tokenCheckerFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll().antMatchers(HttpMethod.GET, "/oauth/login")
                .permitAll().antMatchers(HttpMethod.POST, "/oauth/accessToken").permitAll().antMatchers(HttpMethod.GET, "/Employee/errorRecordDownload/**").permitAll().anyRequest()
                .fullyAuthenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint()).and()
                .logout().addLogoutHandler(logoutHandler()).logoutRequestMatcher(new AntPathRequestMatcher("/oauth/logout"));
    }
    @Bean
    protected LogoutHandler logoutHandler() {
       return new PulseLogoutHandler(); 
    }
    @Bean
    protected AccessDeniedHandler accessDeniedHandler() {
        return new PulseAccessDeninedHandler();
    }

    @Bean
    AuthenticationManager getAuthenticationManager() {
        return new PulseAuthenticationManager();
    }

    @Bean
    UserDetailsService userDetailService() {
        return new PulseUserDetailService();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManager();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

  @Bean
  protected WebClient getWSO2WebServiceClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
      TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
      SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
              .build();
      
      JAXRSClientFactoryBean bean = new JAXRSClientFactoryBean();
      bean.setAddress(wsoEndPoint);
      bean.setProperties(Collections.emptyMap());
      bean.setUsername(wso2Username);
      bean.setPassword(wso2Password);
      bean.getFeatures().add(new LoggingFeature());
      WebClient client  = bean.createWebClient();
      HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
      TLSClientParameters params = conduit.getTlsClientParameters();
      if (params == null) {
          params = new TLSClientParameters();
          conduit.setTlsClientParameters(params);
      }
      params.setSslContext(sslContext);
    
      params.setDisableCNCheck(true);
      return client;
  }
}
