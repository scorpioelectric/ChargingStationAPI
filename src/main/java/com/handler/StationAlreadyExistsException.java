package com.handler;

public class StationAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 73072271803927705L;
	private String errorMessage;
	 
    public StationAlreadyExistsException() {
        super();
    }
 
    public StationAlreadyExistsException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
}
