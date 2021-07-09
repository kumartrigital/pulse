/**
 * 
 */
package com.gss.pulseworkflow.oauth.wso2.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * @author SAURABH
 *
 */
public class WSO2RequestInterceptor extends AbstractPhaseInterceptor<Message> {
    
    public WSO2RequestInterceptor() {
        super(Phase.RECEIVE);
    }

    public WSO2RequestInterceptor(String phase) {
        super(phase);
      
    }

    @Override
    public void handleMessage(Message message) throws Fault {
      
      System.out.println(message);
    }
    
    
    @Override
    public void handleFault(Message message) {
        // TODO Auto-generated method stub
        super.handleFault(message);
    }

   
    
}
