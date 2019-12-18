package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.entity.Homework;

public interface HomeworkService {
	//添加作业
	boolean addHomework(Homework homework);
	
	//获取作业题目
	List<HomeworkNameDTO> getHomeworkName(String userName); 
	
	// 获取所教授课程的作业信息
	List<HomeworkInfoDTO> getHomeworkById(String id);
	
	//获取所学课程的作业信息
	List<HomeworkNameDTO> getHomeworkName1(String userName);
	
	//学生获取作业题目
	List<HomeworkNameDTO> getStuHomeworkName(String studentId);
}
