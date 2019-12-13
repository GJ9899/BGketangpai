package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lgj.ktp.entity.Course;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

//    int insert(Course record);

    int insertSelective(Course record);

//    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    //添加课程
    int addCourse(Course course);
    
    //根据id查找课程
    Course getCourseById(String id);
    
    //显示所有课程
    List<Course> showCourse();
}