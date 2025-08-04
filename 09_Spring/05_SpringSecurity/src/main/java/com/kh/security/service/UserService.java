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
public class UserService{

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
		//user.setPwd(bcpe.encode(user.getPwd()));
		userMapper.addUser(user);
		System.out.println(user);
	}

	public User loginUser(User user)
	{
		User vo = userMapper.loginUser(user.getId());
		
		if(vo!=null && bcpe.matches(user.getPwd(), vo.getPwd()))
		{
			System.out.println("Service : " + vo);
			return vo;
		}
		return null;
	}
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userMapper.loginUser(username);
//		System.out.println(user);
//		return user;
//	}



}
