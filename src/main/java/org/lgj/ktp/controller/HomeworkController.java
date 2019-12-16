package org.lgj.ktp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.lgj.ktp.entity.Homework;
import org.lgj.ktp.service.HomeworkService;
import org.lgj.ktp.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
}
