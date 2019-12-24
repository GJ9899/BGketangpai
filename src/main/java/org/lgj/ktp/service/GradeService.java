package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.AddScoreDTO;
import org.lgj.ktp.dto.GetFileDTO;
import org.lgj.ktp.dto.GetSubmitInfo;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.dto.SubmittedDTO;

public interface GradeService {
	//提交作业
	boolean submitHomework(SubmitHomeworkDTO submitHomeworkDTO);
	
	//获取提交的作业地址
	GetSubmitInfo getFileAddress(GetFileDTO getFileDTO);
	
	//获取已交作业学生信息
	List<SubmittedDTO> getSubmitHomework(String homeworkId);
	
	//记录成绩
	boolean addScore(AddScoreDTO addScoreDTO);
}
