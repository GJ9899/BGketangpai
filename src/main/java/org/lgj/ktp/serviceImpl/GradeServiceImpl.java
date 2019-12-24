package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.GradeMapper;
import org.lgj.ktp.dto.AddScoreDTO;
import org.lgj.ktp.dto.GetFileDTO;
import org.lgj.ktp.dto.GetSubmitInfo;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.dto.SubmittedDTO;
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

	@Override
	public GetSubmitInfo getFileAddress(GetFileDTO getFileDTO) {
		return gradeMapper.getFileAddress(getFileDTO.getHomeworkId(),getFileDTO.getUserId());
	}

	@Override
	public List<SubmittedDTO> getSubmitHomework(String homeworkId) {
		return gradeMapper.getSubmitHomework(homeworkId);
	}

	@Override
	public boolean addScore(AddScoreDTO addScoreDTO) {
		return gradeMapper.addScore(addScoreDTO) > 0;
	}

}
