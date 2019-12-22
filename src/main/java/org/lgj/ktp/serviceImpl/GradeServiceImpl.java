package org.lgj.ktp.serviceImpl;

import org.lgj.ktp.dao.GradeMapper;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public boolean submitHomework(SubmitHomeworkDTO submitHomeworkDTO) {
		return gradeMapper.submitHomework(submitHomeworkDTO) > 0;
	}

}
