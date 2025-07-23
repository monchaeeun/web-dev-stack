package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {

	void addBoard(Board board);
	List <Board> allBoard();
	List <Board> searchBoard();
	void updateBoard(Board board);
	void deleteBoard(Board board);
}
