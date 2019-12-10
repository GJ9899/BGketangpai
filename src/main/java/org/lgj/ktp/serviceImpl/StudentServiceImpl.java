package org.lgj.ktp.serviceImpl;

import org.lgj.ktp.dao.StudentMapper;
import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.entity.Student;
import org.lgj.ktp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public boolean register(Student student) {
		return studentMapper.register(student) > 0;
	}

	@Override
	public Student login(LoginInfo loginInfo) {
		Student student = studentMapper.login(loginInfo.getPhoneMail(),loginInfo.getPassword());
		return student;
	}
}
