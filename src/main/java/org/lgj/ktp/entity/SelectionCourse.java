package org.lgj.ktp.entity;

public class SelectionCourse {
    private String id;

    private String courseId;

    private String selecterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getSelecterId() {
        return selecterId;
    }

    public void setSelecterId(String selecterId) {
        this.selecterId = selecterId == null ? null : selecterId.trim();
    }
}