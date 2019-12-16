package org.lgj.ktp.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.entity.Student;
import org.lgj.ktp.service.StudentService;
import org.lgj.ktp.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@CrossOrigin
@Api
public class StudentController {
	@Autowired
	private StudentService studentService;
	

	/**
	 * 学生注册
	 * 2019-12-03
	 * @param student
	 * @return
	 */
	@ApiOperation(value = "注册", notes = "注册")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JSONResult regisster(@RequestBody Student student) {
		JSONResult jsonResult = new JSONResult();
		student.setId(UUID.randomUUID().toString().replace("-", ""));
		boolean success = studentService.register(student);
		if (success) {
			jsonResult.setMessage("success");
		} else {
			jsonResult.setMessage("手机或邮箱已注册");
		}
		return jsonResult;
	}

	/**
	 * 学生登录
	 * 2019-12-03
	 * @param loginInfo
	 * @return
	 */
	@ApiOperation(value = "登录", notes = "登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult login(@RequestBody LoginInfo loginInfo,HttpSession session) {
		JSONResult jsonResult = new JSONResult();
		
		Student student = studentService.login(loginInfo);
		if (student != null) {
			jsonResult.setMessage("success");
			session.setAttribute("user", student);
			jsonResult.setData(student);
		} else {
			jsonResult.setMessage("登录失败");
		}
		return jsonResult;
	}
	
}
