package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.HomeworkMapper;
import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.entity.Homework;
import org.lgj.ktp.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeWorkServiceImpl implements HomeworkService{
	@Autowired
	private HomeworkMapper homeworkMapper;

	@Override
	public boolean addHomework(Homework homework) {
		return homeworkMapper.addHomework(homework) > 0;
	}

	@Override
	public List<HomeworkNameDTO> getHomeworkName(String userName) {
		return homeworkMapper.getHomeworkName(userName);
	}

	@Override
	public List<HomeworkInfoDTO> getHomeworkById(String id) {
		return homeworkMapper.getHomeworkById(id);
	}

	@Override
	public List<HomeworkNameDTO> getHomeworkName1(String userName) {
		return homeworkMapper.getHomeworkName1(userName);
	}

	@Override
	public List<HomeworkNameDTO> getStuHomeworkName(String studentId) {
		return homeworkMapper.getStuHomeworkName(studentId);
	}

}
