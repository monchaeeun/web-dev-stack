package com.kh.practice.model;

import java.time.LocalDate;

import com.kh.practice.model.Department;
import com.kh.practice.model.UserInfo;

public class UserInfoController {
	
	private UserInfo[] userList = {new UserInfo(), 
									new UserInfo(), 
									new UserInfo()};
	private int count = 0;
	
	// 로그인 -> 유저 정보 클라이언트! 
	public UserInfo login(String id, String password) {
		for(UserInfo user : userList) {
			if(id.equals(user.getId()) 
							&& password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	
	// 오버로딩!
	public void addUser(int userNo, String id, String password, String email, String name) {
		userList[count].setUserNo(userNo);
		userList[count].setId(id);
		userList[count].setPassword(password);
		userList[count].setEmail(email);
		userList[count].setName(name);
		count++;
	}
	
	public void addUser(String phone, String addr, String gender, 
					LocalDate birthDate,int deptNo) {
		userList[count].setPhone(phone);
		userList[count].setAddr(addr);
		userList[count].setGender(gender);
		userList[count].setBirthDate(birthDate);
		userList[count].setDeptNo(deptNo);
		
		//지금 테이블이 상태여서 지금부터 추가된 코드 어려우면 괜찮아요
		//여기서만 보게 될거에요!
		Department dept = new Department(deptNo, DeptType.findDeptName(deptNo));
		userList[count].setDepartment(dept);
	}
	
	// 메서드 1개
	public void updateUser(UserInfo user) {
		for(UserInfo info : userList) {
			if(user.getUserNo() == info.getUserNo()) {
				info = user;
			}
		}
	}

}


