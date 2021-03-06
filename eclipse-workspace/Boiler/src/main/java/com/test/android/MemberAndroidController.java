package com.test.android;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Member;
import com.test.entity.MemberId;
import com.test.mapper.BoilerMapper;

@RestController // Controller에서 RestController로 바꾼 것.
public class MemberAndroidController {

	@Autowired // 의존성 주입(DI: Dependency Injection) 공부할 필요 있음
	BoilerMapper mapper;
	
	@GetMapping("/android/boilerData")
	List<Member> getMemberList(){
		return mapper.selectMemberList();
	}
	
	@GetMapping("/android/boilerUpdate/status={status}/temp={temp}")
	public String getInsertStatus(@PathVariable("status") int status,@PathVariable("temp") int temp) {
		mapper.insertStatus(status,temp);
		return "redirect:/member/memberList";
	}
	
//	@GetMapping("/android/updateTemp/{status}/{temp}")
//	public String getUpdateAge(@PathVariable("temp") int temp,@PathVariable("status") int status) {
//		
//		mapper.updateMember(status, temp);
//		return "redirect:/member/memberList";
//	}
//	
	
	
	@GetMapping("/android/IDData")
	List<MemberId> getMemberList_ID(){
		return mapper.selectMemberList_ID();
	}

	@GetMapping("/android/IDData/userid={userid}/username={username}/userpw={userpw}")
	public String getInsertStatusID(@PathVariable("userid") String userid,@PathVariable("username") String username,@PathVariable("userpw") String userpw) {
		mapper.insertStatusID(userid,username,userpw);
		return "good";
	}
	
	

}
