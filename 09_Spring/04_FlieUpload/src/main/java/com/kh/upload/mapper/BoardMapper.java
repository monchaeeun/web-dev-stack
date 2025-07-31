package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.dto.BoardDTO;
import com.kh.upload.dto.PageDTO;
import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {

	void insert(Board board);
	List <Board> selectAll();
	Board select(int no);
	int update(BoardDTO dto);
	int delete(int no);
	List <Board> search(PageDTO paging);
	int total();
	List<Board> showBoard(PageDTO paging);
	int searchTotal(String keyword);
}
