package com.example.demo.board.module;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByName(String name); //�Խ��� �̸��� �ش��ϴ� Board ��ü�� ��ȯ�ϴ� �޼���
}
