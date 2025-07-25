package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {

	void insert(Board board);
	List <Board> selectAll();
	Board select(int no);
	void update(Board board);
	void delete(int no);
}
