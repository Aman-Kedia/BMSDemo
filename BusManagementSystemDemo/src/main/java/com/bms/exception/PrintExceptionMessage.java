package com.bms.exception;

public class PrintExceptionMessage extends Exception {
	String message;
	
	public PrintExceptionMessage(String message) {
		super(message);
	}
}
