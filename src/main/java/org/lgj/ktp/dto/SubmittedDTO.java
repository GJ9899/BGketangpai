package org.lgj.ktp.dto;

public class SubmittedDTO {
	private String score;
	
	private String id;
	
	private String number;
	
	private String name;
	
	private String bestScore;
	
	private String submitTime;
	
	private String fileAddress;
	
	

	public String getScore() {
		return score;
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

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getBestScore() {
		return bestScore;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public String getFileAddress() {
		return fileAddress;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBestScore(String bestScore) {
		this.bestScore = bestScore;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	
	
}
