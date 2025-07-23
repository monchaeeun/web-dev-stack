package com.kh.upload.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService implements BoardMapper{

	@Autowired
	private BoardMapper mapper;

	@Override
	public void addBoard(Board board) {
		mapper.addBoard(board);
	}

	@Override
	public List<Board> allBoard() {
		return mapper.allBoard();
	}

	@Override
	public List<Board> searchBoard() {
		return mapper.searchBoard();
	}

	@Override
	public void updateBoard(Board board) {
		mapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(Board board) {
		mapper.deleteBoard(board);
	}
	
	
}
