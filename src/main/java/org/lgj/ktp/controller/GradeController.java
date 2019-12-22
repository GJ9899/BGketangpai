package org.lgj.ktp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.service.GradeService;
import org.lgj.ktp.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/grade")
@RestController
@CrossOrigin
@Api
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	/**
	 * 上传作业文件
	 * @param file
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
	public JSONResult addFile(@RequestParam(name = "file_data", required = false) MultipartFile file) {
		JSONResult jsonResult = new JSONResult<>();
	       //文件上传
	       String fileName = file.getOriginalFilename();
	       String newCompanyFilePath = "";
	       if (!file.isEmpty()) {
	           try {
	        	   newCompanyFilePath = "D:\\Program Files (x86)\\eclipse-workspace\\BGketangpai\\src\\main\\resources\\homework\\"+ fileName;

	               File newFile = new File(newCompanyFilePath);
	               if (!newFile.exists()) {
	                   newFile.createNewFile();
	               }
	               BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
	               out.write(file.getBytes());
	               out.flush();
	               out.close();
	           } catch (FileNotFoundException e) {
	               e.printStackTrace();
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	       }
	       
	       String filePath = "http://localhost:8081/homework/file/" + fileName;
	       jsonResult.setData(filePath);
	       jsonResult.setMessage("success");
	       return jsonResult;
	   }
	
	
	@RequestMapping(value = "/submitHomework",method = RequestMethod.POST)
	@ApiOperation(value = "提交作业",notes = "提交作业")
	public JSONResult submitHomework(@RequestBody SubmitHomeworkDTO submitHomeworkDTO) {
		JSONResult jsonResult = new JSONResult<>();
		submitHomeworkDTO.setId(UUID.randomUUID().toString().replace("-", ""));
		boolean success = gradeService.submitHomework(submitHomeworkDTO);
		if(success) {
			jsonResult.setMessage("success");
		}
		else {
			jsonResult.setMessage("false");
		}
		return jsonResult;
	}
}
