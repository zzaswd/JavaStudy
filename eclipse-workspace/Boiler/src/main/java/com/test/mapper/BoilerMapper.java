package com.test.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.entity.Member;
import com.test.entity.MemberId;

@Mapper // mapper라는 것을 컴파일러에게 알림
public interface BoilerMapper {
	@Select("select status, temp, date from boiler order by date desc")// 알파벳 순서로 정렬해라. + 
	public List<Member> selectMemberList();
	
	@Insert("insert into boiler(status,temp) values (\'${status}\',\'${temp}\')")
	public void insertStatus(@Param("status") int status, @Param("temp") int temp);

	@Update("update	boiler set status =${status} where temp=\'${temp}\'")
	public void updateMember(@Param("status")int status, @Param("temp") int temp);

	@Select("select * from tbl_test order by id desc")
	public List<MemberId> selectMemberList_ID();
	
	@Insert("insert into tbl_test(userid,username,userpw) values (\'${userid}\',\'${username}\',\'${userpw}\')")
	public void insertStatusID(@Param("userid") String userid,
				@Param("username") String username, @Param("userpw") String userpw);

}

