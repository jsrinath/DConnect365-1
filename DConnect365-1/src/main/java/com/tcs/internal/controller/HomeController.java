package com.tcs.internal.controller;

import java.net.Authenticator.RequestorType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/saveAppointment",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> saveAppointment(@RequestParam("deptName") String deptName,@RequestParam("drName") String drName,
			@RequestParam("dateSel") String dateSel,@RequestParam("timeSel") String timeSel) {
		System.out.println("home" + deptName+timeSel );
		BookingDetails bd = new BookingDetails();
		bd.setDept(deptName);
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateSel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		bd.setDoctorName(drName);
		bd.setBookingDate(date1);
		bd.setPatientName("Whoami");
		bookingRepo.save(bd);
		return new ResponseEntity<String>("{\"result\":\"success\"}",HttpStatus.OK) ;
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
		for(BookingDetails bd:bdList) {
			System.out.println(bd.getPatientName());
		}
		ModelAndView mv =new ModelAndView("index.html","patientlIst",bdList);
		return mv;
	}
	
	@RequestMapping("/mdTable")
	public String getIndessx() {
		System.out.println("sss");
		return "mdTable.html";
	}
	
	
}
