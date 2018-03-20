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
	private Long id; // �Խñ� ��ȣ pk
	private String author; //�Խñ� �ۼ���
	private String title; //�Խñ� ����
	private String content; //�Խñ� ����
	private Date createdAt; //�Խñ� ������¥
	
	/*
	 * @ManyToOne ������̼� ���� ���� : 
	 * http://jdm.kr/blog/142
	 * */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Board board; //�Խñ��� �޸� �Խ���
	
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
