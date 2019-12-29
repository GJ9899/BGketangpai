package org.lgj.ktp.dto;

public class AddScoreDTO {
	private String gradeId;
	
	private String score;
	
	private String time;
	
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getGradeId() {
		return gradeId;
	}

	public String getScore() {
		return score;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
