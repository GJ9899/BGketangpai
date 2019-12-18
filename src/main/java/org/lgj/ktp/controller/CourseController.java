package org.lgj.ktp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.lgj.ktp.config.RandomStringUtil;
import org.lgj.ktp.dto.AddCourseDTO;
import org.lgj.ktp.dto.DeleteCourseDTO;
import org.lgj.ktp.dto.EditCourseDTO;
import org.lgj.ktp.entity.Course;
import org.lgj.ktp.service.CourseService;
import org.lgj.ktp.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/course")
@RestController
@CrossOrigin
@Api
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	/**
	 * 添加课程 2019-12-11
	 * @param addCourseDTO
	 * @return
	 */
	@RequestMapping(value = "/addCourse",method = RequestMethod.POST)
	@ApiOperation(value = "添加课程",notes = "添加课程")
	public JSONResult addCourse(@RequestBody AddCourseDTO addCourseDTO) {
		//1.添加课程
		JSONResult jsonResult = new JSONResult<>();
		Course course = new Course();
		course.setId(UUID.randomUUID().toString().replace("-", ""));
		course.setConditions(addCourseDTO.getConditions());
		course.setClassName(addCourseDTO.getClassName());
		course.setCourseName(addCourseDTO.getCourseName());
		course.setCreaterId(addCourseDTO.getCreaterId());
		Date currentTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = format.format(currentTime);
		course.setCreateTime(createTime);
		course.setSemester(addCourseDTO.getSemester());
		course.setYear(addCourseDTO.getYear());
		course.setAddCode(RandomStringUtil.getRandString());
		boolean success = courseService.addCourse(course);
		if (success) {
			//2.根据id查找课程
			Course course2 = courseService.getCourseById(course.getId());
			jsonResult.setMessage("success");
			jsonResult.setData(course2);
		}
		else {
			jsonResult.setMessage("false");
		}
		return jsonResult;
	}
	
	/**
	 * 展示所有课程
	 * @return
	 */
	@RequestMapping(value = "/showCourse",method = RequestMethod.GET)
	@ApiOperation(value = "展示所有课程",notes = "展示所有课程")
	public JSONResult showCourse(@RequestParam("id")String id) {
		JSONResult jsonResult = new JSONResult<>();
		List<Course> courseList = courseService.showCourse(id);
		jsonResult.setData(courseList);
		jsonResult.setTotalCount(courseList.size());
		return jsonResult;
	}
	
	/**
	 * 根据id获取课程
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCourseById",method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取课程",notes = "根据id获取课程")
	public Course getCourseById(@RequestParam("id") String id) {
		Course course = courseService.getCourseById(id);
		return course;
	}
	
	/**
	 * 删除课程
	 * @param deleteCourseDTO
	 * @return
	 */
	@RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
	@ApiOperation(value = "退课",notes = "退课")
	public JSONResult deleteCourse(@RequestBody DeleteCourseDTO deleteCourseDTO) {
		JSONResult jsonResult = new JSONResult<>();
		//1.判断这门课程是 “学” 还是 “教”
		//2."学"：删除选课表里面这条信息
		//3.“教”：删除选课表里面的选课，删除这门课程
		//4.删除这门课的作业
		return jsonResult;
	}
	
	/**
	 * 编辑课程
	 * @param editCourseDTO
	 * @return
	 */
	@RequestMapping(value = "/editCourse",method=RequestMethod.POST)
	@ApiOperation(value = "编辑课程",notes = "编辑课程")
	public JSONResult editCourse(@RequestBody EditCourseDTO editCourseDTO) {
		JSONResult jsonResult = new JSONResult<>();
		boolean success = courseService.editCourse(editCourseDTO);
		if(success) {
			jsonResult.setMessage("success");
		}
		else {
			jsonResult.setMessage("false");
		}
		return jsonResult;
	}
	
	/**
	 * 获取教师教授的课程、选择的课程
	 * @param teacherId
	 * @return
	 */
	@RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
	@ApiOperation(value = "获取教师教授的课程、选择的课程",notes = "获取教师教授的课程、选择的课程")
	public JSONResult getAllCourse(@RequestParam("teacherId")String teacherId) {
		JSONResult jsonResult = new JSONResult<>();
		List<Course> courseLsList = courseService.getAllCourse(teacherId);
		jsonResult.setData(courseLsList);
		return jsonResult;
	}
}
