package com.kh.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.vo.Film;

@Mapper
public interface filmMapper {
	List<Film> showFilm();
	List<Film> showFilm1(PagingDTO paging);
	int total();
}
