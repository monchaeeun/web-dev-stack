package com.kh.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

//DAO 역할
@Mapper
public interface MemberMapper {
	void register(Member member);
	Member login(Member member);
	List<Member> allMember();
	void update(Member member);
	void delete(Member member);
	void selectDelete(List<String> idList);
	List<Member> search(SearchDTO dto);
	}
