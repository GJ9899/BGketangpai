package org.lgj.ktp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.entity.Student;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    //注册
    int register(Student student);
    
    //登录
    Student login(@Param("phoneMail")String phoneMail,@Param("password")String password);
}