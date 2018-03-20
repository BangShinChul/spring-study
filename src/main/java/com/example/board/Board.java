package com.example.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {
	/*
	 * @Entity, @Id, @GeneratedValue ������̼� ���� ���� : 
	 * http://jdm.kr/blog/121
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // �Խñ� ��ȣ pk
	public String getName() {
		return name; // �Խ��� �̸�
	}

	public Date getCreatedAt() {
		return createdAt; //�Խ��� ������¥
	}

	private String name;
	private Date createdAt;
	
	protected Board() {}
	
	public Board(String name) {
		this.name = name;
		this.createdAt = new Date();
	}
	
}
