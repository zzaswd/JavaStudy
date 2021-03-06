package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@Controller
public class MemberController {

	//의존성 주입
	
//	BoardMapper mapper;
//	public MemberController(BoardMapper mapper) { // 매개변수에 주입. 이렇게 하면 클래스 변수들이 힙으로 안가고 메서드로 감. 이러면 안정적.	}
//		this.mapper = mapper;
//	이게 귀찮으니깐 자바에선 어노테이션을 통해 구현하게 해줌
	
	@Autowired
	BoardMapper  mapper;

	
	@GetMapping("/member/memberList")
	public void listMember(Model model) {
		model.addAttribute("list", mapper.selectMemberList());
	}
	@GetMapping("/member/memberRegistry")
	public void getMemberRegistry() {}
	
	
	@PostMapping("member/memberRegistry")
	public String postMemberRegistry(Member member) {
		mapper.insertMember(member.getUserid(),member.getUsername(),member.getAge());
		return "redirect:/member/memberList";
		
	}
	
}