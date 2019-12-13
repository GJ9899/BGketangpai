package org.lgj.ktp.dto;

public class AddCourseDTO {
	private String courseName;

    private String className;

    private String year;

    private String semester;

    private String conditions;

    private String createrId;

	public String getCourseName() {
		return courseName;
	}

	public String getClassName() {
		return className;
	}

	public String getYear() {
		return year;
	}

	public String getSemester() {
		return semester;
	}

	public String getConditions() {
		return conditions;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
    
    
}
