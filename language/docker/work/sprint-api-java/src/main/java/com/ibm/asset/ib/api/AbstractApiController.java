package com.ibm.asset.ib.api;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;

import com.ibm.asset.ib.config.APIConfig;
import com.ibm.asset.ib.model.dmt.ApplicationPackageStatusModel;

public abstract class AbstractApiController {
	
    @Autowired
    protected APIConfig config;
    
    protected String buildURL(String api) {
    	StringBuffer sb=new StringBuffer();
//    	sb.append( config.getHost()).append(":").append( config.getPort()).append( api);
    	sb.append( config.getHost()).append( api);
    	return sb.toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    private ApplicationPackageStatusModel handleException(MethodArgumentNotValidException e){
    	System.out.println("@@ERROR@@");
    	e.printStackTrace();
    	
    	ApplicationPackageStatusModel status=new ApplicationPackageStatusModel();
    	StringBuilder sb=new StringBuilder();
    	for(ObjectError ee:e.getBindingResult().getAllErrors()) {
        	System.out.println( ee.getDefaultMessage());
        	System.out.println( ee.getCode());
        	for(String cc:ee.getCodes()) {
            	System.out.println( cc);
            	sb.append( cc).append(" / ");
            	break;
        		
        	}
//        	System.out.println( ee.getObjectName());
//        	for(Object o : ee.getArguments()) {
//        		if( o instanceof DefaultMessageSourceResolvable) {
//        			DefaultMessageSourceResolvable r=(DefaultMessageSourceResolvable)o;
//               		System.out.println( r.getCodes());
//               	        			
//        		}else {
//        		System.out.println( o);
//        		}
//        	}
        	
        	

    		sb.append( ee.getDefaultMessage()).append("\n");
    	}
//    	System.out.println( sb.toString());
    	
    	status.setMessage( sb.toString());
    	return status;
    }
    /*
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    private ApplicationPackageStatusModel handleException2(MethodArgumentNotValidException e){
    	System.out.println("@@ERROR@@");

    	e.printStackTrace();
    	
    	ApplicationPackageStatusModel status=new ApplicationPackageStatusModel();
    	StringBuilder sb=new StringBuilder();
    	for(ObjectError ee:e.getBindingResult().getAllErrors()) {
    		sb.append( ee.toString()).append("\n");
    	}
    	
    	status.setMessage( sb.toString());
    	return status;
    }
*/
}
