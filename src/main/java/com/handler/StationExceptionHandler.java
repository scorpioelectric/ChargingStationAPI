package com.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  
public class StationExceptionHandler {
	  @ExceptionHandler(StationNotFoundException.class)
	    public ResponseEntity<StationErrorResponseEnt> handleStnNotFoundException(Exception ex)  {
		  StationErrorResponseEnt errorResponse = new StationErrorResponseEnt();
	        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        return new ResponseEntity<StationErrorResponseEnt>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	  
	  @ExceptionHandler(StationAlreadyExistsException.class)
	    public ResponseEntity<StationErrorResponseEnt> handleStnExistsException(Exception ex) {
		  StationErrorResponseEnt errorResponse = new StationErrorResponseEnt();
	        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	        errorResponse.setErrorMessage(ex.getMessage());
	        return new ResponseEntity<StationErrorResponseEnt>(errorResponse, HttpStatus.OK);
	    }
	  
	   
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<StationErrorResponseEnt> handleGenericException(Exception ex) {
	    	StationErrorResponseEnt errorResponse = new StationErrorResponseEnt();
	        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setErrorMessage("There is some techncal issue");
	        return new ResponseEntity<StationErrorResponseEnt>(errorResponse, HttpStatus.OK);
	    }
}
