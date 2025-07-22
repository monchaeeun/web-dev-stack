package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.mapper.filmMapper;
import com.kh.paging.vo.Film;

@Service
public class filmService implements filmMapper{
	
	@Autowired
	private filmMapper mapper;
	
	@Override
	public List<Film> showFilm()
	{
		return mapper.showFilm();
	}
	@Override
	public List<Film> showFilm1(PagingDTO paging)
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
		return mapper.showFilm1(paging);
	}
	@Override
	public int total() {
		
		return mapper.total();
	}
	
	
}
