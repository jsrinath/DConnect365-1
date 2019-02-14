package com.tcs.internal.controller;

import java.net.Authenticator.RequestorType;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String getIndex() {
		System.out.println("test");
		return "hello.html";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String alertmMe() {
		System.out.println("home");
		return "Mainpage.html";
	}
	
	@RequestMapping(value="/PatientHist",method=RequestMethod.GET)
	public String getPatientHistory() {
		System.out.println("home");
		return "index.html";
	}
	
	@RequestMapping("/mdTable")
	public String getIndessx() {
		System.out.println("sss");
		return "mdTable.html";
	}
	
}
