package com.mBoard.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mBoard.entity.Board;
import com.mBoard.entity.Reply;
import com.mBoard.mapper.BoardMapper;
import org.apache.commons.io.*;


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
	String postBoardRegister(Board board,@RequestParam("uploadFile") MultipartFile multipartFile) { // uploadFile은 board.Register에 선언된 이름
		
		
		String filePath = "C:\\Repository\\file\\"; // C밑에 첨부파일을 모아놓을 경로 만들어 놓기.
		File targetFile = new File(filePath);
		if(!multipartFile.isEmpty()) {  // 만약 파일등록이 되었다면?
			
			String originFileName = multipartFile.getOriginalFilename(); //파일 이름 가져오는 메서드
			Long filesize = multipartFile.getSize(); // 파일사이즈 정보 가져오는 메서드
			
			board.setFilename(originFileName);
			board.setFilesize(filesize);
			
			targetFile = new File(filePath + originFileName);
			try {
				multipartFile.transferTo(targetFile);  // 실제적으로 파일을 전송하는 메서드.
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} 
		
		mapper.insertList(board.getUserid(), board.getMwriter(),board.getMtitle(),board.getMcontent(),board.getFilename(),board.getFilesize());
	
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
	
	// 파일 다운로드
	@GetMapping("/board/fileDownload") // 주소는 boardview.html에 있는 function과 맞추는 것.
	void fileDownload(@RequestParam("seqno") int seqno, HttpServletResponse rs)  // function에서 seqno를 받는다고 했으니깐 Request 선언.
			throws Exception {
		
		Board fileInfo = mapper.viewList(seqno);
		String filePath = "C:\\Repository\\file\\";
		String orgFileName = fileInfo.getFilename();
		
		// 파일의 모든 값을 fileByte에 저장하면 1byte씩 짤려 저장. 그 길이를 구하면 결국 파일의 사이즈.
		byte fileByte[] = FileUtils.readFileToByteArray(new File(filePath + orgFileName)); // 경로 + filename -> Full 경로.
		
		
		rs.setContentType("application/octet-stream");
		rs.setContentLength(fileByte.length);
		rs.setHeader("Content-Disposition", "attachment;fileName=\"" + URLEncoder.encode(orgFileName,"UTF-8") + "\";");
		rs.getOutputStream().write(fileByte);
		rs.getOutputStream().flush();
		rs.getOutputStream().close();
	}

	// View.html에서 Post 방식으로 보냈기 때문에 Postmapping
	@ResponseBody
	@PostMapping("/board/Reply")
	List<Reply> postReply(Reply reply, @RequestParam("option") String option, @RequestParam("seqno") int seqno){
		// view에서 option = I라는 값을 보냈음. 
		if(option.equals("I")) {
			 mapper.insertReplyList(seqno, reply.getReplywriter(), reply.getReplycontent());
		}
			 List<Reply> replyList = mapper.selectReplyList(seqno);
			 	
			 return replyList;
		
	
}}
