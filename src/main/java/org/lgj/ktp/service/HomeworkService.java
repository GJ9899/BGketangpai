package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.GetAllHomeworkDTO;
import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.dto.HomeworkSubInfo;
import org.lgj.ktp.dto.IsSubmitDTO;
import org.lgj.ktp.dto.SearchHomeworkDTO;
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
	
	//获取提交作业页面所需作业信息
	HomeworkSubInfo getSubHomeworkbyId(String homeworkId);
	
	//查看作业是否提交
	String isSubmitHomework(IsSubmitDTO isSubmitDTO);
	
	//获取已交作业人数
	int getSubmitCount(String homeworkId);
	
	//获取未批改作业人数
	int getUncheckCount(String homeworkId);
	
	//获取所有作业
	List<GetAllHomeworkDTO> getAllHomework(SearchHomeworkDTO searchHomeworkDTO);
	
	String getScore(String homeworkId,String studentId);
}
