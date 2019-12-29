package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.InformationMapper;
import org.lgj.ktp.dto.InformationDTO;
import org.lgj.ktp.entity.Information;
import org.lgj.ktp.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InforamtionServiceImpl implements InformationService{

	@Autowired
	InformationMapper informationMapper;
	@Override
	public boolean addInformation(InformationDTO informationDTO) {
		return informationMapper.addInformation(informationDTO) > 0;
	}
	@Override
	public String getHomeworkName(String courseId) {
		return informationMapper.getHomeworkName(courseId);
	}
	@Override
	public List<Information> getInformation(String userId) {
		return informationMapper.getInformation(userId);
	}

}
