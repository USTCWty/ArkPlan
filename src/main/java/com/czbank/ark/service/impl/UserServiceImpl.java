package com.czbank.ark.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		User user = userMapper.selectUserByName(name);
		if (user==null) return false;
		if (user.getUserPassword().equals(password)) {
			return true;
		}
		return false;
	}

	// for test
	public List<User> getAllUser() {
		List<User> users = userMapper.selectUser();
		return users;
	}

	public int addUser(User user) {		
		return userMapper.addUser(user);

	}

	 @Override   
	 public boolean batchImport(String fileName, MultipartFile file) {      
		 boolean notNull = false;      
		 List<User> userList = new ArrayList<>();      
		 boolean isExcel2003 = true;      
		 if (fileName.matches("^.+\\.(?i)(xlsx)$")) {         
			 isExcel2003 = false;      
		 }      
		 InputStream is=null;
		try {
			is = file.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
		 Workbook wb = null;      
		 if (isExcel2003) {         
			 try {
				wb = new HSSFWorkbook(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
		 } else {         
			 try {
				wb = new XSSFWorkbook(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
		 }      
		 Sheet sheet =  (Sheet) wb.getSheetAt(0);      
		 if(sheet!=null){         
			 notNull = true;      
			 }      
		 User user;      
		 for (int r = 2; r <= ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据        
			 Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(r);//通过sheet表单对象得到 行对象         
			 if (row == null){            
				 continue;         
			 }         
			 //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException         
			 user = new User();               
			 String username = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值              
  
			 String password = row.getCell(1).getStringCellValue();  
			 
			 String userrole =row.getCell(2).getStringCellValue();
			 Date date = new Date();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String time = dateFormat.format(date).toString();
			 //完整的循环一次 就组成了一个对象         
			 user.setUserName(username);         
			 user.setUserPassword(password);   
			 user.setUserRole(userrole);
			 user.setSubmitTime(time);
			 userList.add(user);      
			 }     
		 	for (User userResord : userList) {         
		 		String name = userResord.getUserName();         
		 		int cnt = 0;
		 		User myuser=userMapper.selectUserByName(name);         
		 		if (myuser==null) {            
		 			userMapper.addUser(userResord);            
		 			System.out.println(" 插入 "+userResord);         
		 		} else {            
		 			userMapper.updateUser(userResord);            
		 			System.out.println(" 更新 "+userResord);        
		 		}      
		 	}      
		 	return notNull;   
	}
}
