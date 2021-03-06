package com.board.back.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.model.Board;
import com.board.back.service.BoardService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	// get paging board # 페이징 처리를 할 수 있도록 수정
	@GetMapping("/board")
	public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num", required=false) Integer p_num) {
		if (p_num == null || p_num <= 0) p_num = 1;
		
		return boardService.getPagingBoard(p_num);
	}

	// 목록 페이지
//	@GetMapping("/board")
//	public List<Board> getAllBoards(){
//		
//		return boardService.getAllBoard();
//	}
	
	// 작성 페이지
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board) {
		System.out.println("@PostMapping(\"/board\")");
		System.out.println(board.toString());
		return boardService.createBoard(board);
	}
	
	// 상세보기
	@GetMapping("/board/{no}")
	public ResponseEntity<Board> getBoardByNo
	(@PathVariable Integer no){
		
		return boardService.getBoard(no);
	}
	
	// 수정하기
	@PutMapping("/board/{no}")
	public ResponseEntity<Board> updateBoardByNo
	(@PathVariable Integer no, @RequestBody Board board){
		
		return boardService.updateBoard(no, board);
	}
	
	// 삭제하기
	@DeleteMapping("/board/{no}")
	public ResponseEntity<Map<String, Boolean>> deleteBoardByNo
	(@PathVariable Integer no){
		
		return boardService.deleteBoard(no);
		
	}
	
}
	
	



