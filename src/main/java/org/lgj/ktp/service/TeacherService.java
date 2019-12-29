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
	
	//获取教师姓名
	List<String> getTeacherName(String studentId);
	
	//删除作业
	boolean deleteHomework(String homeworkId);
	
	//删除课程
	boolean deleteCourse(String courseId);
	
	String checkPassword(String userId,String password);
	
	//删除作业
	boolean deleteworkByCourseId(String courseId);
	
	//删除选课表信息
	boolean deleteSelectCourse(String courseId);
}
