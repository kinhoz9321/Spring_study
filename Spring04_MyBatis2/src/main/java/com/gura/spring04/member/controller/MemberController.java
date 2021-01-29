package com.gura.spring04.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dto.MemberDto;
import com.gura.spring04.member.service.MemberService;

@Controller
public class MemberController {
	//핵심 의존 객체 주입받기
	@Autowired
	private MemberService service;
	
	//회원 목록 보기 요청 처리
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		service.getMemberList(mView);
		mView.setViewName("member/list");
		return mView;
	}
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertform() {
		//요청 처리할 비즈니스 로직은 없고 , view page 의 위치만 리턴해주면 된다.
		return "member/insertform";
	}
	
	//회원 추가 요청 처리
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute("dto") MemberDto dto, ModelAndView mView) {
		service.addMember(dto);
		mView.setViewName("member/insert");
		return mView;
	}
	
	/*
	 * @ModelAttribute("dto") MemberDto dto
	 * ("dto") 를 쓰지 않으면
	 * .jsp 페이지에서 dto.name 을 했을 때 이름이 출력되지 않는다.
	 */
	
	//회원 정보를 삭제하는 메소드
	@RequestMapping("/member/delete")
	public ModelAndView delete(@RequestParam int num, ModelAndView mView) {
		service.deleteMember(num);
		mView.setViewName("redirect:/member/list.do");
		return mView;
	}
	
	//회원 정보 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getMember(num, mView);
		mView.setViewName("member/updateform");
		return mView;
	}
	
	//회원 정보 수정 요청 처리
	@RequestMapping("/member/update")
	public ModelAndView update(@ModelAttribute("dto") MemberDto dto, ModelAndView mView) {
		service.updateMember(dto);
		mView.setViewName("member/update");
		return mView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
