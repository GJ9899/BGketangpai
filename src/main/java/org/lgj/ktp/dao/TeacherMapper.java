package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.dto.StudentListDTO;
import org.lgj.ktp.dto.TeacherInfoDTO;
import org.lgj.ktp.entity.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    //获取教师姓名
    List<String> getTeacherName(@Param("studentId")String studentId);
    
    //删除作业
    int deleteHomework(@RequestParam("homeworkId")String homeworkId);
    
    String checkPassword(@Param("userId")String userId,@Param("password")String password);
    
    //删除课程
    int deleteCourse(@Param("courseId")String courseId);
    
    //删除课程作业
    int deleteworkByCourseId(@Param("courseId")String courseId);
    
    //删除选课表
    int deleteSelectCourse(@Param("courseId")String courseId);
    
}