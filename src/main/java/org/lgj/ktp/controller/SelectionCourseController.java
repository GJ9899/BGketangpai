package org.lgj.ktp.controller;

import java.util.List;
import java.util.UUID;

import org.lgj.ktp.dao.SelectionCourseMapper;
import org.lgj.ktp.dto.SelectionCourseDTO;
import org.lgj.ktp.entity.Course;
import org.lgj.ktp.entity.SelectionCourse;
import org.lgj.ktp.service.SelectionCourseService;
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

@RestController
@RequestMapping("/selectionCourse")
@CrossOrigin
@Api
public class SelectionCourseController {
	@Autowired
	private SelectionCourseService selectionCourseService;
	
	/**
	 * 加入课程
	 * @param selectionCourseDTO
	 * @return
	 */
	@RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
	@ApiOperation(value = "加入课程",notes = "加入课程")
	public JSONResult selectCourse(@RequestBody SelectionCourseDTO selectionCourseDTO) {
		JSONResult jsonResult = new JSONResult<>();
		//判断课程是否存在
		//检查这个人是否选择过这门课程
		//1.根据加课码得到课程id
		String courseId = selectionCourseService.getCourseIdByAddCode(selectionCourseDTO.getAddCode());
		System.out.println("courseId:" + courseId);
		boolean success = false;
		//课程存在
		if(courseId != null) {
			//2.将数据添加到选课表
			SelectionCourse selectionCourse = new SelectionCourse();
			selectionCourse.setCourseId(courseId);
			selectionCourse.setSelecterId(selectionCourseDTO.getSelecterId());
			selectionCourse.setId(UUID.randomUUID().toString().replace("-", ""));
			success = selectionCourseService.selectCourse(selectionCourse);
			System.out.println("success" + success);
			//3.返回信息
			if(success) {
				jsonResult.setMessage("success");
			}
			else {
				jsonResult.setMessage("你已经选了这门课程");
			}
		}
		//课程不存在
		else {
			jsonResult.setMessage("课程不存在");
		}
		return jsonResult;
	}
	
	/**
	 * 获取已选的全部课程
	 * @param selecterId
	 * @return
	 */
	@RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
	@ApiOperation(value = "获取全部已选课程",notes = "获取全部已选课程")
	public JSONResult getAllCourse(@RequestParam("selecterId")String selecterId) {
		JSONResult jsonResult = new JSONResult<>();
		//获取全部已选课程的id
//		List<String> courseId = selectionCourseService.getAllCourseId(selecterId);
		//根据这些id获取对应课程的信息
		List<Course> courseList = selectionCourseService.getCourseInfo(selecterId);
//		for (int i = 0; i < courseId.size(); i++) {
//			courseList.add(selectionCourseService.getCourseInfo(courseId.get(i)));
//		}
		jsonResult.setData(courseList);
		return jsonResult;
	}
	 
	/**
	 * 获取同学数量
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/getClassmateCount",method = RequestMethod.GET)
	@ApiOperation(value = "获取同学数量",notes = "获取同学数量")
	public Integer getClassmateCount(@RequestParam("courseId")String courseId) {
		Integer count = selectionCourseService.getClassmateCount(courseId);
		return count;
	}
}
