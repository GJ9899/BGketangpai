package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.entity.Course;
import org.lgj.ktp.entity.SelectionCourse;

@Mapper
public interface SelectionCourseMapper {
    int deleteByPrimaryKey(String id);

//    int insert(SelectionCourse record);

    int insertSelective(SelectionCourse record);

    SelectionCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SelectionCourse record);

    int updateByPrimaryKey(SelectionCourse record);
    
    String getCourseIdByAddCode(@Param("addCode")String addCode);
    
    int selectCourse(SelectionCourse selectionCourse);
    
    List<String> getAllCourseId(@Param("selecterId")String selecterId);
    
    List<Course> getCourseInfo(@Param("selecterId")String selecterId);
}