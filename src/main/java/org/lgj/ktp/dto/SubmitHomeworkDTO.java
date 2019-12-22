package org.lgj.ktp.dto;

public class SubmitHomeworkDTO {
	private String id;
	
	private String homeworkId;
	
	private String studentId;
	
	private String submitTime;
	
	private String fileAddress;
	
	private String message;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHomeworkId() {
		return homeworkId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public String getFileAddress() {
		return fileAddress;
	}

	public String getMessage() {
		return message;
	}

	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
