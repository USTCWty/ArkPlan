package com.czbank.ark.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.czbank.ark.model.Company;
import com.czbank.ark.model.User;
import com.czbank.ark.service.CompanyService;
import com.czbank.ark.service.UserService;
import com.czbank.ark.util.ArkResponse;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;

	@RequestMapping("/test")
	public String testSpring() {
		return "spring boot is areadly start by wty";
	}

	@RequestMapping("/count")
	public int countUser() {
		return userService.countUser();
	}

	@RequestMapping("/login")
	public ArkResponse userLogin(@RequestBody Map<String, String> map) {
		String name = map.get("username").toString();
		String password = map.get("password").toString();
		ArkResponse response = new ArkResponse();
		boolean isUser = userService.isUser(name, password);
		if (isUser) {

			response.setResponseCode(200);
			response.setResponseMsg("成功");
		} else {
			response.setResponseCode(201);
			response.setResponseMsg("账号或密码有误");

		}
		return response;

	}

	@RequestMapping("/addUser")

	public ArkResponse addUser(@RequestBody Map<String, String> map) {
		String name = map.get("username").toString();
		String password = map.get("password").toString();
		String userRole = map.get("userRole").toString();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date).toString();
		User user = new User();
		user.setUserName(name);
		user.setUserPassword(password);
		user.setUserRole(userRole);
		user.setSubmitTime(time);
		int num = userService.addUser(user);
		ArkResponse response = new ArkResponse();

		if (num == 1) {
			Company company =new Company();
			company.setCompanyName(user.getUserName());
			companyService.insertCompany(company);
			response.setResponseCode(200);
			response.setResponseMsg("成功");
		} else {
			response.setResponseCode(201);
			response.setResponseMsg("注册用户失败");
		}
		return response;
	}

	@RequestMapping("/getUser")
	public List<User> userFind() {
		return userService.getAllUser();

	}
	
	@RequestMapping("/deleteUser")
	public int deleteUserByName(HttpServletRequest request){
		String userName =request.getParameter("userName");
		return userService.deleteUser(userName);
	}

	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletResponse response) throws IOException {		
		List<User> users = userService.getAllUser();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = null;
		row = sheet.createRow(0);// 创建第一个单元格
		row.setHeight((short) (26.25 * 20));
		row.createCell(0).setCellValue("用户信息列表");// 为第一行单元格设值

		CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
		sheet.addMergedRegion(rowRegion);

		row = sheet.createRow(1);
		row.setHeight((short) (22.50 * 20));// 设置行高
		row.createCell(0).setCellValue("用户名");// 为第一个单元格设值
		row.createCell(1).setCellValue("密码");// 为第二个单元格设值
		row.createCell(2).setCellValue("角色");// 为第三个单元格设值
		for (int i = 0; i < users.size(); i++) {
			row = sheet.createRow(i + 2);
			User user = users.get(i);
			row.createCell(0).setCellValue(user.getUserName());
			row.createCell(1).setCellValue(user.getUserPassword());
			row.createCell(2).setCellValue(user.getUserRole());
		}
		sheet.setDefaultRowHeight((short) (16.5 * 20)); // 列宽自适应
		for (int i = 0; i <= 13; i++) {
			sheet.autoSizeColumn(i);
		}
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		OutputStream os = response.getOutputStream();
		Date date =new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date).toString();
		response.setHeader("Content-disposition", "attachment;filename="+time+"user.xls");// 默认Excel名称
		wb.write(os);
		os.flush();
		os.close();
	}

	@RequestMapping(value = "/import")   
	public void exImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session) {      
		boolean a = false;      
		String fileName = file.getOriginalFilename();      
		try {         
			a = userService.batchImport(fileName, file);      
		} catch (Exception e) {         
			e.printStackTrace();      
		}      
	}


}
