package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.service.MemberService;
import com.kh.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("register")
	public void register(){}
	
	@PostMapping("register")
	public String register(Member vo)
	{
		try {
			service.register(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login(){}
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request)
	{
		try {
			Member member = service.login(vo);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("search")
	public void search(){}
	
	@PostMapping("find")
	public String search(@RequestParam("id") String id, Model model)
	{
		try {
			Member member = service.search(id);
			model.addAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "result";
	}
	@GetMapping("allMember")
	public String allMember(Model model)
	{
		try {
			ArrayList<Member> m = service.printAll();
			model.addAttribute("list", m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "allMember";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	
}
