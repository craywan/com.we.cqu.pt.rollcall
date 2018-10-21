package edu.uddp.model;

public class TeaSignStatistic {
    private Integer id;

    private String signId;

    private String lessonId;

    private String teaId;

    private String unsignId;

    private Integer unsignNum;

    private String weeks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId == null ? null : signId.trim();
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId == null ? null : lessonId.trim();
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId == null ? null : teaId.trim();
    }

    public String getUnsignId() {
        return unsignId;
    }

    public void setUnsignId(String unsignId) {
        this.unsignId = unsignId == null ? null : unsignId.trim();
    }

    public Integer getUnsignNum() {
        return unsignNum;
    }

    public void setUnsignNum(Integer unsignNum) {
        this.unsignNum = unsignNum;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks == null ? null : weeks.trim();
    }
}