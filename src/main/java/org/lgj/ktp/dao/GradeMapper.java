package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.dto.AddScoreDTO;
import org.lgj.ktp.dto.GetFileDTO;
import org.lgj.ktp.dto.GetSubmitInfo;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.dto.SubmittedDTO;
import org.lgj.ktp.entity.Grade;

@Mapper
public interface GradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    
    //提交作业
    int submitHomework(SubmitHomeworkDTO submitHomeworkDTO);
    
    ////获取提交的作业地址
    GetSubmitInfo getFileAddress(@Param("homeworkId")String homeworkId,@Param("userId")String userId);
    
  //获取已交作业学生信息
  	List<SubmittedDTO> getSubmitHomework(String homeworkId);
  	
  	//记录成绩
  	int addScore(AddScoreDTO addScoreDTO);
}