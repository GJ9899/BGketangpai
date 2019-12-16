package org.lgj.ktp.dto;

public class DeleteCourseDTO {
	private String courseId;
	
	private String userId;
	
	private String password;

	public String getCourseId() {
		return courseId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
