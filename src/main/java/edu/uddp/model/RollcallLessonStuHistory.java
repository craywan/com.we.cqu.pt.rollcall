package edu.uddp.model;

public class RollcallLessonStuHistory {
    private Integer id;

    private String stuId;

    private String lessonId;

    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId == null ? null : lessonId.trim();
    }

    public String getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(String createdAt) {
        this.createdAt = createdAt == null ? null : createdAt.trim();
    }
}