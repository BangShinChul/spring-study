package com.example.demo.board.module;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.Board;
import com.example.demo.board.Post;

/*
 * @RestController 어노테이션 설명 : 
 * http://doublesprogramming.tistory.com/105
 * @Controller는 뷰를 리턴하는것이고,
 * @RestController는 데이터를 리턴하는 것이다. 
 * */

/* @RequestMapping 어노테이션 설명 : 
 * http://yang1650.tistory.com/133
 * */
@RestController
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	/*
	 * @PathVariable 어노테이션 설명 : 
	 * https://code.i-harness.com/ko/q/12e2e53
	 * */
	@RequestMapping(value="/{boardname}/info", method={RequestMethod.GET, RequestMethod.HEAD})
	public ResponseEntity<Board> info(@PathVariable String boardname){
		return ResponseEntity.ok(boardService.findBoard(boardname));
	}
	
	@RequestMapping(value="/{boardname}", method={RequestMethod.GET, RequestMethod.HEAD})
	public ResponseEntity<List<Post>> listPosts(@PathVariable String boardname){
		return ResponseEntity.ok(boardService.findPosts(boardname));
	}
	
	public ResponseEntity<Map<String, Object>> resourceNotFoundException(ResourceNotFoundException exception, Locale locale){
		System.out.print(exception.getError());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", exception.getStatus());
		body.put("error", exception.getError());
		body.put("message", messageSource.getMessage(exception.getCode(), exception.getArgs(), locale).orElse("No message available"));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
}
