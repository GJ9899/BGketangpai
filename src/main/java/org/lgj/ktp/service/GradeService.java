package org.lgj.ktp.service;

import org.lgj.ktp.dto.SubmitHomeworkDTO;

public interface GradeService {
	//提交作业
	boolean submitHomework(SubmitHomeworkDTO submitHomeworkDTO);
}
