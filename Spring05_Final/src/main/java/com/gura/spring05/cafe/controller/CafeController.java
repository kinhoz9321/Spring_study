package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService service;
	
	//글목록 요청 처리
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		service.getList(mView, request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	//글 상세보기 요청 처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("cafe/detail");
		return mView;
	}
	
	//새글 저장 폼 요청 처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		return "cafe/private/insertform";
	}
	
	//새글 저장 요청 처리 (form 전송은 POST 로 받기)
	@RequestMapping(value = "/cafe/private/insert", method = RequestMethod.POST)
	public String insert(CafeDto dto, HttpSession session) {
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		service.saveContent(dto);
		
		return "cafe/private/insert";
	}
	
	//글 수정 폼 요청 처리
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("cafe/private/updateform");
		return mView;
	}
	
	//글 수정 요청 처리
	@RequestMapping("/cafe/private/update")
	public String update(@ModelAttribute("dto") CafeDto dto) {
		service.updateContent(dto);
		return "cafe/private/update";
	}
	
	//글 삭제 요청 처리
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num) {
		service.deleteContent(num);
		return "cafe/private/delete";
	}
}
