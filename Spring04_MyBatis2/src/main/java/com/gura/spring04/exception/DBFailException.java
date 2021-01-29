package com.gura.spring04.exception;

public class DBFailException extends RuntimeException{
	//생성자
	public DBFailException(String message) {
		super(message);
	}
}
