package com.example.board.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController ������̼� ���� : 
 * http://doublesprogramming.tistory.com/105
 * @Controller�� �並 �����ϴ°��̰�,
 * @RestController�� �����͸� �����ϴ� ���̴�. 
 * */

/* @RequestMapping ������̼� ���� : 
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
	//�����ϴٸ���
	//https://medium.com/@oopchoi/spring-boot-handsonlab-ksug-2-746a116fd756
	public ResponseEntity<Board>
}
