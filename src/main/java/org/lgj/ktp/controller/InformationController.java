package org.lgj.ktp.controller;

import java.util.List;

import org.lgj.ktp.entity.Information;
import org.lgj.ktp.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/information")
@RestController
@CrossOrigin
@Api
public class InformationController {
	@Autowired
	private InformationService informationService;
	
	@RequestMapping(value = "/getInformation",method = RequestMethod.GET)
	@ApiOperation(value = "获取信息",notes = "获取信息")
	public List<Information> getInformation(@RequestParam("userId")String userId){
		return informationService.getInformation(userId);
	}
	
}
