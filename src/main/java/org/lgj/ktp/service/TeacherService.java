package org.lgj.ktp.service;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public interface TeacherService {
	//注册
	boolean register(Teacher teacher);
	
	//登录
	Teacher login(LoginInfo loginInfo);
}
