package com.kh.ajax.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.ajax.vo.Member;

@Mapper
public interface MemberMapper {
	Member idCheck(String id);
	boolean idBoolCheck(String id);
	void register(Member vo);
	
}
