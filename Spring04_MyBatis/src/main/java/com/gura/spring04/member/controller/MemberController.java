package com.gura.spring04.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list.do")
	public ModelAndView list(ModelAndView mView) {
		//1. 회원목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		
		//2. Model(data) 를 담고
		mView.addObject("list", list);
		
		//3. view page 정보도 담고
		mView.setViewName("member/list");
		
		//4. 리턴해준다.
		return mView;
	}
	
	@RequestMapping("/member/insertform.do")
	public String insertform() {
		
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert.do")
	public String insert(@RequestParam String name, String addr) {
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		dao.insert(dto);
		
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/updateform.do")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		MemberDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		mView.setViewName("member/updateform");
		return mView;
	}
	
	@RequestMapping("/member/update.do")
	public String update(@RequestParam int num, String name, String addr) {
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		dao.update(dto);
		
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/delete.do")
	public String delete(@RequestParam int num) {
		
		dao.delete(num);
		
		return "redirect:/member/list.do";
	}
}
