package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.EditCourseDTO;
import org.lgj.ktp.entity.Course;
import org.springframework.stereotype.Component;

@Component
public interface CourseService {
	// 添加课程
	boolean addCourse(Course course);

	// 根据id查找课程
	Course getCourseById(String id);
	
	// 显示所有课程
	List<Course> showCourse(String id);
	
	// 编辑课程
	boolean editCourse(EditCourseDTO editCourseDTO);
	
	//获取所有课程
	List<Course> getAllCourse(String teacherId);
	
	//获取学生成员
	List<String> getStuMember(String courseId);
	
	//获取教师成员
	List<String> getTeaMember(String courseId);
}
