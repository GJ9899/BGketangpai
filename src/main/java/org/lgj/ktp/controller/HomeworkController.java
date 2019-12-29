package org.lgj.ktp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.lgj.ktp.dto.GetAllHomeworkDTO;
import org.lgj.ktp.dto.HomeworkInfoDTO;
import org.lgj.ktp.dto.HomeworkNameDTO;
import org.lgj.ktp.dto.HomeworkSubInfo;
import org.lgj.ktp.dto.InformationDTO;
import org.lgj.ktp.dto.IsSubmitDTO;
import org.lgj.ktp.dto.SearchHomeworkDTO;
import org.lgj.ktp.entity.Homework;
import org.lgj.ktp.service.HomeworkService;
import org.lgj.ktp.service.InformationService;
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
	
	@Autowired
	private InformationService informationService;
	
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
		InformationDTO informationDTO = new InformationDTO();
		informationDTO.setCourseName(informationService.getHomeworkName(homework.getPublishCourseObject()));
		informationDTO.setHomeworkName(homework.getHomeworkName());
		informationDTO.setId(UUID.randomUUID().toString().replace("-", ""));
		informationDTO.setPublishTime(homework.getPublishTime());
		boolean succ = informationService.addInformation(informationDTO);
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
		HomeworkSubInfo homeworkSubInfo = homeworkService.getSubHomeworkbyId(homeworkId);
		return homeworkSubInfo;
	}
	
	/**
	 * 查看作业是否提交
	 * @param isSubmitDTO
	 * @return
	 */
	@RequestMapping(value = "/isSubmitHomework",method = RequestMethod.POST)
	@ApiOperation(notes = "查看作业是否提交",value = "查看作业是否提交")
	public String isSubmitHomework(@RequestBody IsSubmitDTO isSubmitDTO) {
		String id = homeworkService.isSubmitHomework(isSubmitDTO);
		if(id != null) {
			return id;
		}
		else {
			return "false";
		}
	}
	
	/**
	 * 获取已交作业人数
	 * @param homeworkId
	 * @return
	 */
	@RequestMapping(value = "/getSubmitCount",method = RequestMethod.GET)
	@ApiOperation(value = "获取已交作业人数",notes = "获取已交作业人数")
	public int getSubmitCount(@RequestParam("homeworkId")String homeworkId) {
		return homeworkService.getSubmitCount(homeworkId);
	}
	
	/**
	 * 获取未批改作业人数
	 * @param homeworkId
	 * @return
	 */
	@RequestMapping(value = "/getUncheckCount",method = RequestMethod.GET)
	@ApiOperation(value = "获取未批改作业人数",notes = "获取未批改作业人数")
	public int getUncheckCount(@RequestParam("homeworkId")String homeworkId) {
		return homeworkService.getUncheckCount(homeworkId);
	}
	
	@RequestMapping(value = "/getAllHomework",method = RequestMethod.POST)
	@ApiOperation(value = "获取所有作业",notes = "获取所有作业")
	public List<GetAllHomeworkDTO> getAllHomework(@RequestBody SearchHomeworkDTO searchHomeworkDTO){
		List<GetAllHomeworkDTO> list = homeworkService.getAllHomework(searchHomeworkDTO);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setScore(homeworkService.getScore(list.get(i).getId(),searchHomeworkDTO.getUserId()));
		}
		return list;
	}
	
}
