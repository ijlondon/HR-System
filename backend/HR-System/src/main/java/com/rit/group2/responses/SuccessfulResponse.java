package com.rit.group2.responses;

public class SuccessfulResponse extends Response{
	
	public SuccessfulResponse(String message, Object data){
		super(message, false, data);
	}
	
}
