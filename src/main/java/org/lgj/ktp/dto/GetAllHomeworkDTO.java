package org.lgj.ktp.dto;

public class GetAllHomeworkDTO {
	private String id;
	
	private String publishTime;
	
	private String homeworkName;
	
	private String bestScore;
	
	private String score;

	

	public String getPublishTime() {
		return publishTime;
	}

	public String getHomeworkName() {
		return homeworkName;
	}

	public String getBestScore() {
		return bestScore;
	}

	public String getScore() {
		return score;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}

	public void setBestScore(String bestScore) {
		this.bestScore = bestScore;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}	
