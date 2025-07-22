package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.service.filmService;
import com.kh.paging.vo.Film;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class filmController {

	@Autowired
	private filmService service;
	
	@GetMapping("/list")
	public String showFilm(Model model, PagingDTO paging)
	{
		List<Film> list = service.showFilm1(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "list";
	}
}

