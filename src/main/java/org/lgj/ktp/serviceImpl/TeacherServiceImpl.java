package org.lgj.ktp.serviceImpl;


import java.util.List;

import org.lgj.ktp.dao.TeacherMapper;
import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.dto.StudentListDTO;
import org.lgj.ktp.dto.TeacherInfoDTO;
import org.lgj.ktp.entity.Teacher;
import org.lgj.ktp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public boolean register(Teacher teacher) {
		return teacherMapper.register(teacher) > 0;
	}

	@Override
	public Teacher login(LoginInfo loginInfo) {
		Teacher teacher = teacherMapper.login(loginInfo.getPhoneMail(),loginInfo.getPassword());
		return teacher;
	}

	@Override
	public TeacherInfoDTO getTeacherInfo(String courseId) {
		return teacherMapper.getTeacherInfo(courseId);
	}

	@Override
	public List<StudentListDTO> getStudentList(String courseId) {
		return teacherMapper.getStudentList(courseId);
	}
}
