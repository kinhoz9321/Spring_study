package com.gura.spring04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dto.MemberDto;

@Controller
public class JsonTestController {
	@RequestMapping("/json01.do")
	public ModelAndView json01(ModelAndView mView) {
		int num=1;
		String name="투잉";
		String addr="관악구";
		MemberDto dto=new MemberDto(num, name, addr);
		mView.addObject("dto", dto);
		mView.setViewName("json01");
		return mView;
	}
	
	@RequestMapping("/json02")
	@ResponseBody
	public MemberDto json02() {
		int num=2;
		String name="tooing";
		String addr="남구";
		MemberDto dto=new MemberDto(num, name, addr);
		return dto;
	}
	
	@RequestMapping("/json03")
	@ResponseBody
	public Map<String, Object> json03(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", 3);
		map.put("name", "홍홍");
		map.put("addr", "포항");
		return map;
	}
	
	@RequestMapping("/json04")
	@ResponseBody
	public List<String> json04(){
		List<String> list=new ArrayList<String>();
		list.add("홍주");
		list.add("kinhoz");
		list.add("투잉");
		return list;
	}
}
