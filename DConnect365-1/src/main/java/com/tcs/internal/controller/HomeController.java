package com.tcs.internal.controller;

import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.internal.models.BookingDetails;

@Controller
public class HomeController {
	@Autowired
	com.tcs.internal.repo.bookingRepo bookingRepo;
	
	@RequestMapping("/index")
	public String getIndex() {
		  BookingDetails bd = bookingRepo.findBypatientName("Srinath");
		  List<BookingDetails> bdList = bookingRepo.findAll();
		  System.out.println(bdList.get(0).get_id()+""+bdList.get(0).getPatientName());
		  System.out.println("test"+bd.getPatientName()+bd.getBookingDate()+bd.getDoctorName());
		 
		return "hello.html";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String alertmMe() {
		System.out.println("home");
		return "Mainpage.html";
	}
	
	@RequestMapping(value="/PatientHist",method=RequestMethod.GET)
	public ModelAndView getPatientHistory() {
		System.out.println("home");
		List<BookingDetails> bdList = bookingRepo.findAll();
		ModelAndView mv =new ModelAndView("index.html","bdList",bdList);
		return mv;
	}
	
	@RequestMapping("/mdTable")
	public String getIndessx() {
		System.out.println("sss");
		return "mdTable.html";
	}
	
}
