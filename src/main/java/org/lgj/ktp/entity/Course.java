package org.lgj.ktp.entity;

import java.util.Date;

public class Course {
    private String id;

    private String courseName;

    private String className;

    private String year;

    private String semester;

    private String conditions;

    private String createrId;

    private String createTime;

    private String addCode;

    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAddCode() {
        return addCode;
    }

    public void setAddCode(String addCode) {
        this.addCode = addCode == null ? null : addCode.trim();
    }

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", className=" + className + ", year=" + year
				+ ", semester=" + semester + ", conditions=" + conditions + ", createrId=" + createrId + ", createTime="
				+ createTime + ", addCode=" + addCode + "]";
	}
    
    
}