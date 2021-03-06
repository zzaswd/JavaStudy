package com.test.android;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@RestController // Controller에서 RestController로 바꾼 것.
public class MemberAndroidController {

	@Autowired // 의존성 주입(DI: Dependency Injection) 공부할 필요 있음
	BoardMapper mapper;
	
	@GetMapping("/android/memberList")
	List<Member> getMemberList(){
		
		return mapper.selectMemberList();
	}
	
	

	@GetMapping("/android/updateAge/{age}/{userid}")
	public String getUpdateAge(@PathVariable("userid") String userid,@PathVariable("age") int age) {
		
		mapper.updateMember(age, userid);
		return "redirect:/member/memberList";
	}
	
	
}
