package org.lgj.ktp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
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
}