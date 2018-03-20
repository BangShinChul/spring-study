package com.example.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {
	/*
	 * @Entity, @Id, @GeneratedValue 어노테이션 관련 설명 : 
	 * http://jdm.kr/blog/121
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // 게시글 번호 pk
	public String getName() {
		return name; // 게시판 이름
	}

	public Date getCreatedAt() {
		return createdAt; //게시판 생성날짜
	}

	private String name;
	private Date createdAt;
	
	protected Board() {}
	
	public Board(String name) {
		this.name = name;
		this.createdAt = new Date();
	}
	
}
