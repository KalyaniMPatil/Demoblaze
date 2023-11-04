package com.demotest.utilities;

public class InvalidBrowserNameError extends Error {
	String msg;
	public InvalidBrowserNameError(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
