package com.tcs.internal.controller;

import java.net.Authenticator.RequestorType;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.internal.models.BookingDetails;

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
	@RequestMapping(value="/saveAppointment",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> bookAppointment(@RequestParam("deptName") String deptName,@RequestParam("drName") String drName,
			@RequestParam("dateSel") String dateSel,@RequestParam("timeSel") String timeSel) {
		System.out.println("Test" + deptName + drName + dateSel+timeSel);
		BookingDetails bd = new BookingDetails();
		
		return new ResponseEntity<String>("{\"result\":\"success\"}", HttpStatus.OK);
		 
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
