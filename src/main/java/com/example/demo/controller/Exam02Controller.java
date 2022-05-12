package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Exam02Form;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public Exam02Form setUpForm() {
		return new Exam02Form();
	}
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	
	@RequestMapping("/receive")
	public String calc(@Validated Exam02Form exam02Form) {

			Integer num1=
					Integer.parseInt(exam02Form.getNum1());
			Integer num2=
					Integer.parseInt(exam02Form.getNum2());
			Integer answer = num1+num2;
			
			session.setAttribute("num1", num1);
			session.setAttribute("num2", num2);
			session.setAttribute("answer", answer);

			return "redirect:/exam02/toresult";

		}
	

	@RequestMapping("/toresult")
	public String toResult() {
		return "exam02-result";
	}

	@RequestMapping("/to-page1")
	public String toPage1() {
		return "exam02-result2";
	}
}

