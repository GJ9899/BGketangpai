package org.lgj.ktp.serviceImpl;


import org.lgj.ktp.dao.TeacherMapper;
import org.lgj.ktp.dto.LoginInfo;
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
}
