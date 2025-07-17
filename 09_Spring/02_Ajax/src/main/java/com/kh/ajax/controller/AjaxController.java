package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.Service.MemberService;
import com.kh.ajax.vo.Member;



@Controller
public class AjaxController {

    private final PageController pageController;
    
    @Autowired
	private MemberService service; 

	private int count = 0;

    AjaxController(PageController pageController) {
        this.pageController = pageController;
    }
	
	@ResponseBody
	@GetMapping("/count")
	public int count()
	{
		System.out.println(count);
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname)
	{
		System.out.println("닉네임 값 :"+ nickname);
		return nickname;	
	}
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id)
	{
		//Member check = service.idCheck(id);
		//if(check != null) return false;
		
		return service.idBoolCheck(id);
		
	}
}
