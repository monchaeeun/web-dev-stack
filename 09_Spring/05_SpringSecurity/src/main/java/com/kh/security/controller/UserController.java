package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.service.UserService;
import com.kh.security.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/index")
	public void index() {}
	
	
	@GetMapping("/register")
	public void register(){}
	
	@GetMapping("/login")
	public String login(HttpServletRequest requect)
	{
		HttpSession session = requect.getSession();
		session.removeAttribute("user");
		return "/login";
	}
	
	@PostMapping("/register")
	public String addUser(User user)
	{
		User check = userService.idCheck(user);
		if(check != null)
		{
			System.out.println("이미 아이디가 존재합니다");
			return "redirect:/";
		}
		userService.addUser(user);
		System.out.println("회원가입이 완료되었습니다.");
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String loginUser(User user,HttpServletRequest requect)
	{
		HttpSession session = requect.getSession();
		User check = userService.loginUser(user);
		if(check== null)
		{
			System.out.println("아이디나 비밀번호가 틀렸습니다.");
		}
		
		session.setAttribute("user", check);
		return "redirect:/";
	}
}
