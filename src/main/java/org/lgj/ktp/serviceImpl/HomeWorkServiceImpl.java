package org.lgj.ktp.serviceImpl;

import org.lgj.ktp.dao.HomeworkMapper;
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

}
