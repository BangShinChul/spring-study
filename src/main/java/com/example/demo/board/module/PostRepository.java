package com.example.demo.board.module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.Board;
import com.example.demo.board.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByBoard(Board board);
	Post findOne(long id);
}
