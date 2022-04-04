package com.mBoard.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mBoard.entity.Board;
import com.mBoard.mapper.BoardMapper;



@Controller // 이 친구가 컨트롤러라는 어노테이션
public class BoardController { // BoardMapper에서 선언한 interface를 가져와서 사용하는 것.

	
	@Autowired // 의존성 주입이란 방법으로 mapper 클래스 변수가 생성됌. --> new 어쩌구 안써도 되는 것.
	BoardMapper mapper;
	
	// 게시물 목록 보기
	@GetMapping("/board/boardList") // 작동이 수행될 URL. 애를 실행시킬 method 밑에 선언. + board/boardList라고 했으니 template 밑에 board 폴더 있어야함
	
	void getBoardList(Model model) { // Model이란 객체 생성.
		model.addAttribute("list", mapper.selectList()); // html쪽에서 인식할 수 있는 변수 , 변수 값 
	}
	
	// 게시물 내용 보기
	@GetMapping("/board/boardView")
	void getBoardView(Model model, @RequestParam("seqno") int seqno) {
		model.addAttribute("view",mapper.viewList(seqno));
	}
	
	//게시물 등록 화면 보기
	@GetMapping("/board/boardRegister")
	void getBoardRegister() {}
	
	// 게시물 등록
	@PostMapping("/board/boardRegister")
	String postBoardRegister(Board board) {
		mapper.insertList(board.getUserid(), board.getMwriter(),board.getMtitle(),board.getMcontent());
	
		return "redirect://127.0.0.1:8080/board/boardList";
	}
	
	
	//게시물 수정 화면 보기
	@GetMapping("/board/boardModify")
	void getBoardModify(Model model, @RequestParam("seqno") int seqno) {
		model.addAttribute("view",mapper.viewList(seqno));
	}
		
	//게시물 수정
	
	@PostMapping("/board/boardModify")
	String postBoardModify(Board board) {
		mapper.updateList(board.getMwriter(), board.getMtitle(),board.getMcontent(), board.getSeqno());
		return "redirect://127.0.0.1:8080/board/boardView?seqno=" + Integer.toString(board.getSeqno()); // 수정한 seq의 내용을 확인하기 위해 뒤에 board.getSeqno붙임.
	}
	
	// 게시물 삭제
	
	@GetMapping("/board/boardDelete")
		String getBoardDelete(Model model, @RequestParam("seqno" )int seqno) {
			mapper.deleteList(seqno);
			return "redirect://127.0.0.1:8080/board/boardList";
	}
	
	
}
