package com.example.demo.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Exam03Form;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/result")
	public String result(@Validated Exam03Form exam03form) {
		Integer num1 = Integer.parseInt(exam03form.getNum1());
		Integer num2 = Integer.parseInt(exam03form.getNum2());
		Integer num3 = Integer.parseInt(exam03form.getNum3());

		Integer answer = (num1 + num2 + num3);
		Integer answer2 = (int) (answer * 1.1);

		application.setAttribute("num1", num1);
		application.setAttribute("num2", num2);
		application.setAttribute("num3", num3);
		application.setAttribute("answer", answer);
		application.setAttribute("answer2", answer2);

		return "redirect:/exam03/toresult";
	}

	@RequestMapping("/toresult")
	public String toResult() {
		return "exam03-result";
	}

}
