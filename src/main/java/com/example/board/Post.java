package com.example.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // 게시글 번호 pk
	private String author; //게시글 작성자
	private String title; //게시글 제목
	private String content; //게시글 내용
	private Date createdAt; //게시글 생성날짜
	
	/*
	 * @ManyToOne 어노테이션 관련 설명 : 
	 * http://jdm.kr/blog/142
	 * */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Board board; //게시글이 달릴 게시판
	
	protected Post() {}
	
	protected Post(Board board, String author, String title, String content) {
		this.author = author;
		this.title = title;
		this.content = content;
		this.createdAt = new Date();
		
		this.board = board;
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
}
