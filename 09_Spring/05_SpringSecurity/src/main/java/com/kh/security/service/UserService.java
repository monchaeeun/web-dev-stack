package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder bcpe;
	
	public User idCheck(User user) {
		return userMapper.idCheck(user);
	}

	public void addUser(User user) {
		if(user.getId().equals("admin")){
			user.setRole("ROLE_ADMIN");
		}
		else{
			user.setRole("ROLE_USER");
		}
		user.setPwd(bcpe.encode(user.getPwd()));
		userMapper.addUser(user);
		System.out.println(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.loginUser(username);
		return user;
	}



}
