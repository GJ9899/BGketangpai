package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.CourseMapper;
import org.lgj.ktp.entity.Course;
import org.lgj.ktp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseMapper courseMapper;

	@Override
	public boolean addCourse(Course course) {
		return courseMapper.addCourse(course) > 0;
	}

	@Override
	public Course getCourseById(String id) {
		return courseMapper.getCourseById(id);
	}

	@Override
	public List<Course> showCourse() {
		return courseMapper.showCourse();
	}

}
