package com.czbank.ark.service;

import com.czbank.ark.model.User;

public interface UserService {
	public int countUser();
	public boolean isUser(String name,String password);
	public User getUserById();
}
