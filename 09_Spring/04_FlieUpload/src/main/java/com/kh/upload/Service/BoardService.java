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
	public void insert(Board board) {
		mapper.insert(board);
	}

	@Override
	public List<Board> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Board select(int no) {
		return mapper.select(no);
	}

	@Override
	public void update(Board board) {
		mapper.update(board);
	}

	@Override
	public void delete(int no) {
		mapper.delete(no);
	}
	
	
}
