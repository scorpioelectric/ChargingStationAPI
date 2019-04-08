package com.handler;

public class StationNotFoundException extends Exception{
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
