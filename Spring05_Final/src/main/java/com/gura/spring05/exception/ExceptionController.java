package com.gura.spring05.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(DBFailException.class)
	public ModelAndView dbFail(DBFailException e) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception", e);
		mView.setViewName("error/db_fail");
		return mView;
	}
}
