package com.rit.group2.responses;

public class ErrorResponse extends Response{
	
	public ErrorResponse(String errorMessage){
		super(errorMessage, true, null);
	}
	
}
