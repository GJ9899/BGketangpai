package org.lgj.ktp.dto;

public class InformationDTO {
	private String id;
	
	private String courseName;
	
	
	private String publishTime;
	
	private String homeworkName;

	public String getId() {
		return id;
	}

	

	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getPublishTime() {
		return publishTime;
	}

	public String getHomeworkName() {
		return homeworkName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}
	
	
}
