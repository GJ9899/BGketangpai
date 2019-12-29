package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.dto.StudentListDTO;
import org.lgj.ktp.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
	//注册
	boolean register(Student student);
		
	//登录
	Student login(LoginInfo loginInfo);
	
	//获取学生列表
	List<StudentListDTO> getStudentList(String courseId);
	
	//获取学生姓名
	List<String> getStudentName(String courseId);
	
	List<String> getTeacherName(String courseId);
	
	//判断密码是否正确
	String checkPassword(String userId,String password);
	
	//删除课程
	boolean deleteCourse(String userId,String courseId);
}
