package com.gura.spring05.exception;

public class DBFailException extends RuntimeException{
	
	public DBFailException(String message) {
		super(message);
	}
}
