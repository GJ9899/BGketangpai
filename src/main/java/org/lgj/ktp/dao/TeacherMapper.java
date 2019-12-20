package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.dto.StudentListDTO;
import org.lgj.ktp.dto.TeacherInfoDTO;
import org.lgj.ktp.entity.Teacher;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    //注册
    int register(Teacher teacher);
    
    //登录
    Teacher login(@Param("phoneMail")String phoneMail,@Param("password")String password);
    
    //获取教师信息
    TeacherInfoDTO getTeacherInfo(@Param("courseId")String courseId);
    
    //获取学生列表
    List<StudentListDTO> getStudentList(@Param("courseId") String courseId);
}