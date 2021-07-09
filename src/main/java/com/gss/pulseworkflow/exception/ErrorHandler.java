/**
 * 
 */
package com.gss.pulseworkflow.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gss.pulseworkflow.response.ResponseWrapper;

/**
 * @author SAURABH
 *
 */
public class ErrorHandler implements HandlerExceptionResolver {

    @Autowired
    private ObjectMapper mapper;
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ex.printStackTrace();
        ModelAndView view  =  new ModelAndView(this::render);
        ResponseWrapper<String> wrapper = new ResponseWrapper<>();
        wrapper.setErrorCode("500");
        wrapper.setStatus("Error");
        wrapper.setExceptionType(ex.getClass().getSimpleName());
        wrapper.setErrorMessage("System is facing some technical issue please try again. If issue persists please contact support team");
        view.addObject("content", wrapper);
        
        return view;
    }

    
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        mapper.writeValue(response.getOutputStream(), model.get("content"));
        
    }
    
    

    
}
