package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.dto.StudentListDTO;
import org.lgj.ktp.dto.TeacherInfoDTO;
import org.lgj.ktp.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public interface TeacherService {
	//注册
	boolean register(Teacher teacher);
	
	//登录
	Teacher login(LoginInfo loginInfo);
	
	//查询老师信息
	TeacherInfoDTO getTeacherInfo(String courseId);
	
	//获取学生列表
	List<StudentListDTO> getStudentList(String courseId);
}
