package com.czbank.ark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czbank.ark.dao.UserMapper;
import com.czbank.ark.model.User;
import com.czbank.ark.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	public int countUser() {
		// TODO Auto-generated method stub
		int count = userMapper.countAllUser();
		return count;
	}

	public boolean isUser(String name, String password) {
		// TODO Auto-generated method stub
		List<User> users = userMapper.selectUserByName(name);
		User user = null;
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}

		if (user.getUserPassword().equals(password)) {
			return true;
		}
		return false;
	}

	// for test
	public User getUserById() {
		User user = userMapper.selectUserById(1);
		System.out.println("wwwwwwwwwwwww" + user.getUserName());
		return null;
	}

	public int addUser(User user) {		
		return userMapper.addUser(user);

	}

}
