package com.kh.ajax.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.Mapper.MemberMapper;
import com.kh.ajax.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public Member idCheck(String id)
	{
		System.out.println("서비스");
		return mapper.idCheck(id);
	}
	
	public boolean idBoolCheck(String id)
	{
		return mapper.idBoolCheck(id);
	}
	public void register(Member vo)
	{
		
	}
}
