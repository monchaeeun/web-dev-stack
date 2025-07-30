package com.kh.upload.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.dto.BoardDTO;
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
	
	public List<BoardDTO> search(String keyword)
	{
		List<Board> list = mapper.search(keyword);
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
	
	
	
}
