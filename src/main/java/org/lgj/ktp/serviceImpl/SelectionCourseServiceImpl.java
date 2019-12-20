package org.lgj.ktp.serviceImpl;

import java.util.List;

import org.lgj.ktp.dao.CourseMapper;
import org.lgj.ktp.dao.SelectionCourseMapper;
import org.lgj.ktp.entity.Course;
import org.lgj.ktp.entity.SelectionCourse;
import org.lgj.ktp.service.SelectionCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionCourseServiceImpl implements SelectionCourseService{
	
	@Autowired
	private SelectionCourseMapper selectionCourseMapper;
	
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public boolean selectCourse(SelectionCourse selectionCourse) {
		return selectionCourseMapper.selectCourse(selectionCourse) > 0;
	}

	@Override
	public String getCourseIdByAddCode(String addCode) {
		return selectionCourseMapper.getCourseIdByAddCode(addCode);
	}

	@Override
	public List<String> getAllCourseId(String id) {
		return selectionCourseMapper.getAllCourseId(id);
	}

	@Override
	public List<Course> getCourseInfo(String id) {
		return courseMapper.getCourseInfo(id);
	}

	@Override
	public Integer getClassmateCount(String courseId) {
		return selectionCourseMapper.getClassmateCount(courseId);
	}

}
