package org.lgj.ktp.dto;

//提交作业页面所需作业信息
public class HomeworkSubInfo {
	private String id;
	
	private String homeworkName;
	
	private String endTime;
	
	private String endDate;
	
	private String needCheck;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHomeworkName() {
		return homeworkName;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getNeedCheck() {
		return needCheck;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setNeedCheck(String needCheck) {
		this.needCheck = needCheck;
	}
	
	
}
