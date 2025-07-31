package com.kh.upload.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.dto.PageDTO;
import com.kh.upload.dto.BoardDTO;
import com.kh.upload.dto.PageDTO;
import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService{

	@Autowired
	private BoardMapper mapper;

	public void insert(Board board) {
		mapper.insert(board);
	}

	public List<BoardDTO> selectAll() {
		List<Board> list = mapper.selectAll();
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board li : list)
		{
			BoardDTO dto = new BoardDTO();
			dto.setNo(li.getNo());
			dto.setTitle(li.getTitle());
			dto.setContent(li.getContent());
			dto.setUrl(li.getUrl());
			Date formDate = Date.from(li.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formDate);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public Board select(int no) {
		return mapper.select(no);
	}

	public int update(BoardDTO dto) {
		return mapper.update(dto);
	}

	public int delete(int no) {
		return mapper.delete(no);
	}
	
	public List<BoardDTO> search(PageDTO paging)
	{
		List<Board> list = mapper.search(paging);
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board li : list)
		{
			BoardDTO dto = new BoardDTO();
			dto.setNo(li.getNo());
			dto.setTitle(li.getTitle());
			dto.setContent(li.getContent());
			dto.setUrl(li.getUrl());
			Date formDate = Date.from(li.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formDate);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public int total()
	{
		return mapper.total();
	}
	
	
	
	public List<BoardDTO> showBoard(PageDTO paging)
	{	
		/*
		 * 만약에 limit가 10인 경우
		 * page = 1 -> offset = 0
		 * page = 2 -> offset = 10
		 * page = 3 -> offset = 20
		 * 
		 * offset = limit * (page-1)
		 */
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		List<Board> list = mapper.showBoard(paging);
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board li : list)
		{
			BoardDTO dto = new BoardDTO();
			dto.setNo(li.getNo());
			dto.setTitle(li.getTitle());
			dto.setContent(li.getContent());
			dto.setUrl(li.getUrl());
			Date formDate = Date.from(li.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formDate);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public int searchTotal(String keyword) {
	    return mapper.searchTotal(keyword);
	}
}
