package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.config.TokenProvider;
import com.kh.security.service.UserService;
import com.kh.security.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
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
		//로그인 정보 저장
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
	}

	
	//기능
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
		return "redirect:/login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public String loginUser(User user)
	{
		System.out.println("controller  : "+user);
		User vo = userService.loginUser(user);
		System.out.println("service에서 받은 값 : "+ vo);
		if(vo != null)
		{
			//로그인 성공 -> 서버는 토큰 생성만, 값을 가지고 있는건 클라이언트
			//클라이언트 토큰에 저장
			
			//token null 오류
			String token = tokenProvider.create(vo);
			System.out.println("token에 넣은 값 : "+ token);
			return token;
			
		}
		return null;
	}
}
