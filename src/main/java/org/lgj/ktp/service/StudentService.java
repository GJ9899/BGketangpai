package org.lgj.ktp.service;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
	//注册
	boolean register(Student student);
		
	//登录
	Student login(LoginInfo loginInfo);
}
