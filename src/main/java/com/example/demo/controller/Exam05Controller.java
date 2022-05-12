package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	@Autowired
	private MemberRepository repository;

	@RequestMapping("/execute")
	public String execute() {
		Member member = new Member();

	}
}
