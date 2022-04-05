package com.mBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mBoard.entity.Board;
import com.mBoard.entity.Reply;

@Mapper
public interface BoardMapper { // mapper 파일을 interface여야 한다.

	
	// 게시물 목록보기
	@Select("select seqno, userid, mwriter,mtitle,mregdate, mcontent from tbl_mboard order by seqno desc")
	List<Board> selectList(); // 얘는 목록이므로 여러개 반환해야해서 List
	
	// 게시물 상세 내용 보기
	@Select("select seqno, userid, mwriter, mtitle, mregdate, mcontent,filename from tbl_mboard where seqno = ${seqno}")
	Board viewList(@Param("seqno") int seqno);
	
	// 게시물 수정 
	@Update ("update tbl_mboard set mwriter = '${mwriter}',mtitle = '${mtitle}', mcontent = '${mcontent}' where seqno = ${seqno}")
	void updateList(@Param("mwriter") String mwriter, @Param("mtitle") String mtitle, @Param("mcontent") String mcontent , @Param("seqno") int seqno);
	
	// 게시물 등록
	@Insert("insert into tbl_mboard (userid,mwriter,mtitle,mcontent,filename,filesize) values (\'${userid}\',\'${mwriter}\', \'${mtitle}\', \'${mcontent}\',\'${filename}\', \'${filesize}\')")
	void insertList(@Param("userid") String userid,@Param("mwriter") String mwriter, @Param("mtitle") String mtitle,@Param("mcontent") String mcontent ,@Param("filename") String filename, @Param("filesize") long filesize);
	
	// 게시물 삭제
	@Delete("delete from tbl_mboard where seqno=${seqno}")
	void deleteList(@Param("seqno") int seqno);
	
	//댓글 목록 보기
	@Select("select replyseqno, seqno, replywriter, replycontent from tbl_mreply where seqno = ${seqno}")
	List<Reply> selectReplyList(@Param("seqno") int seqno);
	
	//댓글 등록
	@Insert("insert into tbl_mreply(seqno,replywriter,replycontent) values (${seqno},\'${replywriter}\',\'${replycontent}\')")
	void insertReplyList(@Param("seqno") int sepno, @Param("replywriter") String replywriter, @Param("replycontent") String replycontent);
}
