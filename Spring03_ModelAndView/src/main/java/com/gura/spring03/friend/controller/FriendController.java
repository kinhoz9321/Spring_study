package com.gura.spring03.friend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.friend.dto.FriendDto;

@Controller
public class FriendController {
	
	//친구 목록 보기
	
	/* 1 */
	
	@RequestMapping("/friend/list.do") // 반드시 / 있어야 함
	public String list(HttpServletRequest request) {
		//view page 에 전달할 Model(data)
		List<String> list=new ArrayList<String>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		//request scope 에 "list" 라는 키값으로 Model 담기
		request.setAttribute("list", list);
		
		return "friend/list"; // 반드시 / 없어야 함
	}
	
	/* 2 */
	
	/*
	 * ModelAndView 객체는
	 * Model(data) 와 view page 정보를 동시에 담을 수 있는 객체이다.
	 * ModelAndView 객체를 컨트롤러의 메소드에서 리턴해주면
	 * ModelAndView 객체에 담긴 data는 자동으로 request scope 에 담기고 ***
	 * ModelAndView 객체에 담긴 view page 정보대로 forward 이동된다. ***
	 */
	
	@RequestMapping("/friend/list2.do")
	public ModelAndView list2() {
		//view page 에 전달할 Model(data)
		List<String> list2=new ArrayList<String>();
		list2.add("김홍주");
		list2.add("킨호즈");
		list2.add("투명잉간");
		
		//1. ModelAndView 객체를 생성해서 (자주 사용할 것)
		ModelAndView mView=new ModelAndView();
		
		//2. Model(data)를 담고 (items="${list }", List<String> list2)
		mView.addObject("list", list2); 
		
		//3. view page 정보도 담고
		mView.setViewName("friend/list");
		
		//4. 리턴해준다.
		return mView;
	}
	
	/* 3 */
	
	//메소드의 인자로 ModelAndView 를 선언하면 Spring 이 객체를 생성해서 전달해 준다.
	@RequestMapping
	public ModelAndView list3(ModelAndView mView) {//1. ModelAndView 객체를 메소드의 인자로 전달받음
		//view page 에 전달할 Model(data)
		List<String> list3=new ArrayList<String>();
		list3.add("봉봉");
		list3.add("심수");
		list3.add("장지");
		list3.add("니니정");
		list3.add("이나");
		
		//ModelAndView 객체를 직접 생성하지 않고 메소드의 인자로 전달 받아서 사용가능
		//2. Model(data)를 담고
		mView.addObject("list", list3);
		
		//3. view page 정보도 담고
		mView.setViewName("friend/list");
		
		//4. 리턴해준다.
		return mView;
	}
	
	//친구 정보 삭제하기
	
	/* 1 */
	
	/*
	 * [리다일렉트 이동]
	 * 웹브라우저에게 새로운 경로로 요청을 다시 하라고 응답하는게 리다일렉트 이동이다.
	 * 스프링에서 리다일렉트 응답을 할 때는 view page 정보를 
	 * "redirect: '컨텍스트 경로를 제외'한 절대 경로" 와 같이 작성하면 된다.
	 * 
	 * ModelAndView 객체도 같다.
	 * mView.setViewName("redirect: 경로")
	 * 
	 * 이번 예제1 에서 확인할 것
	 * 1) 리다일렉트 이동
	 * - 친구 목록 삭제하기 1,2를 누르면
	 * http://localhost:8888/spring03/friend/list.do 로 이동됨.
	 * 
	 * 2) GET 방식 전송
	 * - 1번 (?num=1) 친구의 정보를 삭제 했습니다.
	 * - 2번 (?num=2) 친구의 정보를 삭제 했습니다.
	 */
	
	@RequestMapping("/friend/delete") //mapping 처리 하지 않으면 home에서부터 500번 탄다. 뭐지?ㅎ
	public String delete(HttpServletRequest request) {
		//삭제할 번호
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println(num+ " 번 친구의 정보를 삭제 했습니다.");
		
		return "redirect:/friend/list.do";
	}
	
	//친구 추가 폼 요청 처리
	@RequestMapping("/friend/insertform")
	public String insertform() {
		
		//수행할 비즈니스 로직은 없고 단순히 view page 정보만 리턴하는 경우도 있다.
		return "friend/insertform";
	}
	
	//폼 전송을 추출하는 세가지 방법
	/* 1 */
	@RequestMapping("/friend/insert")
	public String insert(HttpServletRequest request) {
		
		//폼 전송되는 파라미터 추출
		int num = Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		//추출된 정보 테스트로 출력해보기
		System.out.println(num+"|"+name+"|"+phone);
		
		//view page 로 forward 이동해서 결과 응답하기
		return "friend/insert";
	}
	
	/* 2 */
	@RequestMapping("/friend/insert2")
	public String insert(@RequestParam int num, String name, String phone) {//@RequestParam 사용해서 인자로 파라미터 추출하기
		
		//추출된 정보 테스트로 출력해보기
		System.out.println(num+"|"+name+"|"+phone);
		
		//view page 로 forward 이동해서 결과 응답하기
		return "friend/insert";
	}
	
	/* 3 */
	@RequestMapping("/friend/insert3")
	public String insert(@ModelAttribute FriendDto dto) {
		
		//추출된 정보 테스트로 출력해보기
		System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getPhone());
		
		//view page 로 forward 이동해서 결과 응답하기
		return "friend/insert";
	}
	
	/*
	아래의 작업을 Spring 프레임 워크가 해준다.
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	FriendDto dto=new FriendDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setPhone(phone);
	 */
}
