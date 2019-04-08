package com.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Station Not Found")
public class StationNotFoundException extends IOException{
	   private static final long serialVersionUID = 1L;
	    private String errorMessage;
	 
	   
	    public StationNotFoundException() {
	        super();
	    }
	 
	    public StationNotFoundException(String errorMessage) {
	        super(errorMessage);
	        this.errorMessage = errorMessage;
	    }
	 
	    public String getErrorMessage() {
	        return errorMessage;
	    }
}
