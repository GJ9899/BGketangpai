package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.dto.HomeworkSubInfo;
import org.lgj.ktp.entity.Homework;

@Mapper
public interface HomeworkMapper {
    int deleteByPrimaryKey(String id);

//    int insert(Homework record);

    int insertSelective(Homework record);

//    Homework selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);
    
    //添加作业
    int addHomework(Homework homework);
    
    //获取教授作业题目
    List<HomeworkNameDTO> getHomeworkName(@Param("userId")String userId);
    
    //获取所学作业题目
    List<HomeworkNameDTO> getHomeworkName1(@Param("userId")String userId);
    
    //获取作业信息
    List<HomeworkInfoDTO> getHomeworkById(@Param("id")String id);
    
  //学生获取作业题目
    List<HomeworkNameDTO> getStuHomeworkName(@Param("studentId")String studentId);
    
    //获取提交作业页面所需作业信息
    HomeworkSubInfo getSubHomeworkbyId(@Param("homeworkId")String homeworkId);
}