package com.example.demo.board.module;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.Board;
import com.example.demo.board.Post;

/*
 * @Service ������̼� ���� :
 * http://noritersand.tistory.com/156#@Service

 * @Transactional ������̼� ���� : 
 * http://egloos.zum.com/springmvc/v/495798
 * http://soulduse.tistory.com/40
 * */
@Service
@Transactional
public class BoardService {
	private BoardRepository boardRepository;
	private PostRepository postRepository;
	
	/*
	 * @Autowired ������̼� ���� : 
	 * http://expert0226.tistory.com/195
	 * http://blog.daum.net/easteat15/14
	 * */
	@Autowired
	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@Autowired
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Board findBoard(String boardname) {
		Board board = boardRepository.findByName(boardname);
		if(Objects.isNull(board)) {
			throw new BoardNotFoundException(boardname);
		}
		return board;
	}
	
	public List<Post> findPosts(String boardname) {
		Board board = findBoard(boardname);
		
		return postRepository.findByBoard(board);
	}
	
	private Post getPost(long postId) {
		Post post = postRepository.findOne(postId);
		return post;
	}

}
