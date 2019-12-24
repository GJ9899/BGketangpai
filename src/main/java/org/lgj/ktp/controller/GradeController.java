package org.lgj.ktp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.lgj.ktp.dto.AddScoreDTO;
import org.lgj.ktp.dto.GetFileDTO;
import org.lgj.ktp.dto.GetSubmitInfo;
import org.lgj.ktp.dto.SubmitHomeworkDTO;
import org.lgj.ktp.dto.SubmittedDTO;
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
	public String addImage(@RequestParam(name = "file_data", required = false) MultipartFile file) {
        //文件上传
        String originalName = file.getOriginalFilename();
        String newCompanyImagePath = "";
        if (!file.isEmpty()) {
            try {
                newCompanyImagePath = "D:\\Program Files (x86)\\eclipse-workspace\\BGketangpai\\src\\main\\resources\\static\\"+ originalName;

                File newFile = new File(newCompanyImagePath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "图片上传失败！";
            } catch (IOException e) {
                e.printStackTrace();
                return "图片上传失败！";
            }
        }
        String filePath = "http://localhost:8081/" + originalName;
        return filePath;
    }
	
	/**
	 * 提交作业
	 * @param submitHomeworkDTO
	 * @return
	 */
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
	
	/**
	 * 获取提交的作业地址,留言
	 * @param getFileDTO
	 * @return
	 */
	@RequestMapping(value = "/getFileAddress",method = RequestMethod.POST)
	@ApiOperation(value = "获取提交的作业地址",notes = "获取提交的作业地址")
	public GetSubmitInfo getFileAddress(@RequestBody GetFileDTO getFileDTO) {
		GetSubmitInfo getSubmitInfo = gradeService.getFileAddress(getFileDTO);
		return getSubmitInfo;
	}
	/**
	 * 获取已交作业学生信息
	 * @param homeworkId
	 * @return
	 */
	@RequestMapping(value = "/getSubmitHomework",method = RequestMethod.GET)
	@ApiOperation(value = "获取已交作业学生信息",notes = "获取已交作业学生信息")
	public JSONResult getSubmitHomework(@RequestParam("homeworkId")String homeworkId) {
		JSONResult jsonResult = new JSONResult<>();
		List<SubmittedDTO> submittedDTO = gradeService.getSubmitHomework(homeworkId);
		jsonResult.setData(submittedDTO);
		jsonResult.setTotalCount(submittedDTO.size());
		return jsonResult;
	}
	
	@RequestMapping(value = "/addScore",method = RequestMethod.POST)
	@ApiOperation(value = "记录成绩",notes = "记录成绩")
	public String addScore(@RequestBody AddScoreDTO addScoreDTO) {
		boolean success = gradeService.addScore(addScoreDTO);
		if(success) {
			return "success";
		}
		else {
			return "false";
		}
	}
}
