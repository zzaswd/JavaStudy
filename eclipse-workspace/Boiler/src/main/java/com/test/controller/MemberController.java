package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.entity.Member;
import com.test.mapper.BoilerMapper;

@Controller
public class MemberController {

	@Autowired
	BoilerMapper  mapper;

	@GetMapping("/boiler/boilerData")
	public void listMember(Model model) {
		model.addAttribute("list", mapper.selectMemberList());
	}

	
}