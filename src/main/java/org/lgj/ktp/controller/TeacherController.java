package org.lgj.ktp.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.entity.Teacher;
import org.lgj.ktp.service.TeacherService;
import org.lgj.ktp.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RequestMapping("/teacher")
@RestController
@CrossOrigin
@Api
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 用户注册   2019-12-03
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "注册",notes = "注册")
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public JSONResult regisster(@RequestBody Teacher teacher) {
		JSONResult jsonResult = new JSONResult();
		teacher.setId(UUID.randomUUID().toString().replace("-", ""));
		boolean success = teacherService.register(teacher);
		if(success) {
			jsonResult.setMessage("success");
		}
		else {
			jsonResult.setMessage("手机或邮箱已注册");
		}
		return jsonResult;
	}
	
	/**
	 * 登录 2019-12-03
	 * @param loginInfo
	 * @return
	 */
	@ApiOperation(value = "登录",notes = "登录")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public JSONResult login(@RequestBody LoginInfo loginInfo) {
		JSONResult jsonResult = new JSONResult();
		Teacher teacher = teacherService.login(loginInfo);
		if(teacher != null) {
			jsonResult.setMessage("success");
			jsonResult.setData(teacher);
		}
		else {
			jsonResult.setMessage("登录失败");
		}
		return jsonResult;
	}
	
}
