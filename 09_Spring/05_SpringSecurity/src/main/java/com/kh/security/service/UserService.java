package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService implements UserMapper{

	@Autowired
	private UserMapper userMapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	@Override
	public User idCheck(User user) {
		return userMapper.idCheck(user);
	}

	@Override
	public void addUser(User user) {
		
		userMapper.addUser(user);
	}

	@Override
	public User loginUser(User user) {
		return userMapper.loginUser(user);
	}

}
