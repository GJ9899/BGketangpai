package org.lgj.ktp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.dto.HomeworkSubInfo;
import org.lgj.ktp.entity.Homework;
import org.lgj.ktp.service.HomeworkService;
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
@RequestMapping("/homework")
@CrossOrigin
@Api
public class HomeworkController {
	@Autowired
	private HomeworkService homeworkService;
	
	/**
	 * 添加作业
	 * @param homework
	 * @return
	 */
	@RequestMapping(value = "/addHomework",method = RequestMethod.POST)
	@ApiOperation(notes = "添加作业",value = "添加作业")
	public JSONResult addHomework(@RequestBody Homework homework) {
		JSONResult jsonResult = new JSONResult<>();
		homework.setId(UUID.randomUUID().toString().replace("-", ""));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		homework.setPublishTime(format.format(date));
		boolean success = homeworkService.addHomework(homework);
		if(success) {
			jsonResult.setMessage("success");
		}
		else {
			jsonResult.setMessage("false");
		}
		return jsonResult;
	}
	
	/**
	 * 获取作业题目
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getHomeworkName",method = RequestMethod.GET)
	@ApiOperation(value = "获取作业题目",notes = "获取作业题目")
	public JSONResult getHomeworkName(@RequestParam("userId")String userId) {
		JSONResult jsonResult = new JSONResult<>();
		//所教授课程的作业
		List<HomeworkNameDTO> homeworkName1 = homeworkService.getHomeworkName(userId);
		List<HomeworkNameDTO> homeworkName2 = homeworkService.getHomeworkName1(userId);
		homeworkName1.addAll(homeworkName2);
		jsonResult.setData(homeworkName1);
		return jsonResult;
	}
	
	/**
	  * 根据id获取作业
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getHomeworkById",method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取作业",notes = "根据id获取作业")
	public List<HomeworkInfoDTO> getHomeworkById(@RequestParam("id")String id) {
		
		List<HomeworkInfoDTO>homeworkInfoDTO = homeworkService.getHomeworkById(id);
		return homeworkInfoDTO;
	}
	
	/**
	 * 学生获取作业题目
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/getStuHomeworkName",method = RequestMethod.GET)
	@ApiOperation(value = "学生获取作业题目",notes = "学生获取作业题目")
	public List<HomeworkNameDTO> getStuHomeworkName(@RequestParam("studentId")String studentId) {
		List<HomeworkNameDTO> list = homeworkService.getStuHomeworkName(studentId);
		return list;
	}
	
	/**
	 * 获取提交作业页面所需作业信息
	 * @param homeworkId
	 * @return
	 */
	@RequestMapping(value = "/getSubHomeworkbyId",method = RequestMethod.GET)
	@ApiOperation(value = "获取提交作业页面所需作业信息",notes = "获取提交作业页面所需作业信息")
	public HomeworkSubInfo getHomeworkbyId(@RequestParam("homeworkId")String homeworkId) {
		System.out.println(homeworkId);
		HomeworkSubInfo homeworkSubInfo = homeworkService.getSubHomeworkbyId(homeworkId);
		return homeworkSubInfo;
	}
}
