package org.lgj.ktp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.dto.InformationDTO;
import org.lgj.ktp.entity.Information;

@Mapper
public interface InformationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
    
    int addInformation(InformationDTO informationDTO);
    
    String getHomeworkName(@Param("courseId")String courseId);
    
    List<Information> getInformation(@Param("userId")String userId);
}