package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Exam02Form;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	
	
	@ModelAttribute
	public Exam02Form setUpForm() {
		return new Exam02Form();
	}
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	
	@RequestMapping("/receive")
	public String calc (@Validated Exam02Form exam02Form, BindingResult result,
			RedirectAttributes redirectAttribute) {
		if (result.hasErrors()) {
			return index();
		}else {
			Integer num1=
					Integer.parseInt(exam02Form.getNum1());
			Integer num2=
					Integer.parseInt(exam02Form.getNum2());
			Integer answer = num1+num2;
			
			redirectAttribute.addFlashAttribute("answer",answer);
			return "redirect:/exam02/toresult";
		}
	}
	
	@RequestMapping("/toresult")
	public String toResult() {
		return "exam02-result";
	}
}
