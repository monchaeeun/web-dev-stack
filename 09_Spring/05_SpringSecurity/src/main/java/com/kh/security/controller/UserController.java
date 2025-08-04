package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	//페이지 이동
	@GetMapping("/index")
	public void index() {}
	
	
	@GetMapping("/register")
	public void register(){}
	
	@GetMapping("/login")
	public void login(){}
	
	@GetMapping("/mypage")
	public void mypage() {}

	@GetMapping("/admin")
	public void admin() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
	}

	
	//기능
	@PostMapping("/register")
	public String addUser(User user,HttpServletRequest requect)
	{
		User check = userService.idCheck(user);
		if(check != null)
		{
			System.out.println("이미 아이디가 존재합니다");
			return "redirect:/";
		}
		userService.addUser(user);
		System.out.println("회원가입이 완료되었습니다.");
		HttpSession session = requect.getSession();
		session.removeAttribute("user");
		return "redirect:/login";
	}
	
	@PostMapping("/login")
	public String loginUser(User user,HttpServletRequest requect)
	{
		HttpSession session = requect.getSession();
		User getUser = userService.idCheck(user);
		session.setAttribute("user", getUser);
//		if(check== null)
//		{
//			System.out.println("아이디나 비밀번호가 틀렸습니다.");
//		}
//		
//		session.setAttribute("user", check);
		return "redirect:/mypage";
	}
}
