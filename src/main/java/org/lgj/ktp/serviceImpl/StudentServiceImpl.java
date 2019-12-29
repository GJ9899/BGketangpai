package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.StudentMapper;
import org.lgj.ktp.dto.LoginInfo;
import org.lgj.ktp.dto.StudentListDTO;
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

	@Override
	public List<StudentListDTO> getStudentList(String courseId) {
		return studentMapper.getStudentList(courseId);
	}

	@Override
	public List<String> getStudentName(String courseId) {
		return studentMapper.getStudentName(courseId);
	}

	@Override
	public List<String> getTeacherName(String courseId) {
		return studentMapper.getTeacherName(courseId);
	}

	@Override
	public String checkPassword(String userId, String password) {
		return studentMapper.checkPassword(userId,password);
	}

	@Override
	public boolean deleteCourse(String userId, String courseId) {
		return studentMapper.deleteCourse(userId,courseId) > 0;
	}

}
