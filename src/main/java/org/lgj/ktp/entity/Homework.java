package org.lgj.ktp.entity;


public class Homework {
    private String id;

    private String teacherId;

    private String homeworkName;

    private String introduce;

    private String endDate;

    private String endTime;

    private String forbidSubmit;

    private Integer bestScore;

    private String needCheck;

    private Integer checkAlertValue;

    private Integer dumplicateCheckRate;

    private String publishCourseObject;

    private String publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName == null ? null : homeworkName.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    

    public String getEndDate() {
		return endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getForbidSubmit() {
        return forbidSubmit;
    }

    public void setForbidSubmit(String forbidSubmit) {
        this.forbidSubmit = forbidSubmit == null ? null : forbidSubmit.trim();
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer bestScore) {
        this.bestScore = bestScore;
    }

    public String getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(String needCheck) {
        this.needCheck = needCheck == null ? null : needCheck.trim();
    }

    public Integer getCheckAlertValue() {
        return checkAlertValue;
    }

    public void setCheckAlertValue(Integer checkAlertValue) {
        this.checkAlertValue = checkAlertValue;
    }

    public Integer getDumplicateCheckRate() {
        return dumplicateCheckRate;
    }

    public void setDumplicateCheckRate(Integer dumplicateCheckRate) {
        this.dumplicateCheckRate = dumplicateCheckRate;
    }

    public String getPublishCourseObject() {
        return publishCourseObject;
    }

    public void setPublishCourseObject(String publishCourseObject) {
        this.publishCourseObject = publishCourseObject == null ? null : publishCourseObject.trim();
    }

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

    
}