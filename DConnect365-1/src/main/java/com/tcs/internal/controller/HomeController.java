package com.tcs.internal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String alertmMe() {
		System.out.println("test");
		return "hello.html";
	}
	
}
