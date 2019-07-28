package com.czbank.ark.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.czbank.ark.model.User;

public interface UserService {
	public int countUser();
	public boolean isUser(String name,String password);
	public List<User> getAllUser();
	public int addUser(User user);
	public boolean batchImport(String fileName, MultipartFile file);
}
