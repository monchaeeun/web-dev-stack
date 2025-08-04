package com.kh.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.security.vo.User;

@Mapper
public interface UserMapper {

	User idCheck(User user);
	void addUser(User user);
	User loginUser(String id);
}
