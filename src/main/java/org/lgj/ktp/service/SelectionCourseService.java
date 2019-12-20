package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.entity.Course;
import org.lgj.ktp.entity.SelectionCourse;

public interface SelectionCourseService {
	//添加课程
	boolean selectCourse(SelectionCourse selectionCourse);
	
	//根据加课码得到课程id
	String getCourseIdByAddCode(String addCode);
	
	//获取全部已选课程的id
	List<String> getAllCourseId(String id);
	
	//根据课程id获取课程信息
	List<Course> getCourseInfo(String id);
	
	//获取同学数量
	Integer getClassmateCount(String courseId);
}
