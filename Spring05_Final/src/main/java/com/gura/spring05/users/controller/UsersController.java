package com.gura.spring05.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;
import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	//개인정보 수정 요청 처리
	@RequestMapping(value = "/users/private/update", method = RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView) {
		service.updateUser(dto, session);
		mView.setViewName("users/private/update");
		return mView;
	}
	
	//개인정보 수정폼 요청 처리 (프로필 이미지 수정)
	@RequestMapping("/users/private/updateform")
	public ModelAndView updateform(ModelAndView mView, HttpSession session) {
		service.getInfo(mView, session);
		mView.setViewName("users/private/updateform");
		return mView;
	}
	
	//프로필 이미지 업로드 요청 처리
	@RequestMapping("/users/private/profile_upload")
	public String profile_upload(MultipartFile image, HttpServletRequest request) {
		
		return "redirect:/users/private/updateform.do";
	}
	
	//비밀번호 수정 요청 처리
	@RequestMapping("/users/private/pwd_update")
	public ModelAndView pwd_update(ModelAndView mView, UsersDto dto, HttpSession session) {
		service.updateUserPwd(mView, dto, session);
		mView.setViewName("users/private/pwd_update");
		return mView;
	}
	
	//비밀번호 수정 폼 요청 처리
	@RequestMapping("/users/private/pwd_updateform")
	public String pwd_updateform() {
		return "users/private/pwd_updateform";
	}
	
	//회원 탈퇴 요청 처리
	@RequestMapping("/users/private/delete")
	public String delete(HttpSession session) {
		service.deleteUser(session);
		return "users/private/delete";
	}
	
	//개인정보 보기 요청 처리
	@RequestMapping("/users/private/info")
	public ModelAndView infoLogic(ModelAndView mView, HttpSession session) {
		service.getInfo(mView, session);
		mView.setViewName("users/private/info");
		return mView;
	}
	
	//로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "users/logout";
	}
	
	//로그인 요청 처리
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		service.loginLogic(request, response);
		return "users/login";
	}
	
	//로그인 폼 요청처리
	@RequestMapping("/users/loginform")
	public ModelAndView loginForm(HttpServletRequest request, ModelAndView mView) {
		service.loginFormLogic(request, mView);
		mView.setViewName("users/loginform");
		return mView;
	}
	
	//회원 가입 요청처리
	@RequestMapping(value = "/users/signup", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("dto") UsersDto dto, ModelAndView mView) {
		
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;
	}
	
	//해당 아이디 존재 여부 ajax 요청 처리 (수정 전)
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId, ModelAndView mView){
		boolean isExist=service.isExistId(inputId);
		Map<String , Object> map=new HashMap<String, Object>();
		map.putIfAbsent("isExist", isExist);
		return map;
	}
	
	
	//회원가입 폼 요청처리
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
}
