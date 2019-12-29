package org.lgj.ktp.service;

import java.util.List;

import org.lgj.ktp.dto.InformationDTO;
import org.lgj.ktp.entity.Information;

public interface InformationService {
	//添加消息
	boolean addInformation(InformationDTO informationDTO);
	
	String getHomeworkName(String courseId);
	
	List<Information> getInformation(String userId);
}
