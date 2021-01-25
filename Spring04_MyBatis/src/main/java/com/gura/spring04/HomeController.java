package com.gura.spring04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")//home 설정하고 run 하기
	public String home() {
		
		return "home";
	}
	
}
