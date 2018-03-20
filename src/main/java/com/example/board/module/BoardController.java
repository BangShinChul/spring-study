package com.example.board.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	//여기하다말음
	//https://medium.com/@oopchoi/spring-boot-handsonlab-ksug-2-746a116fd756
	public ResponseEntity<Board>
}
