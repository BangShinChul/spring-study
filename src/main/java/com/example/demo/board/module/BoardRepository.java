package com.example.demo.board.module;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByName(String name); //게시판 이름에 해당하는 Board 객체를 반환하는 메서드
}
