package org.lgj.ktp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
}