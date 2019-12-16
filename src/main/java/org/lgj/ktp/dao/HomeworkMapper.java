package org.lgj.ktp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lgj.ktp.entity.Homework;

@Mapper
public interface HomeworkMapper {
    int deleteByPrimaryKey(String id);

//    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);
    
    //添加作业
    int addHomework(Homework homework);
}