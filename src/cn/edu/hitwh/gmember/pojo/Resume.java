package cn.edu.hitwh.gmember.pojo;

public class Resume {
    private int resume_id;
    private int stu_id;
    private String resume_path;
    private String resume_advice;//所属课程，可为空
    private String resume_advice_time;//负责教师，可为空

    public Resume(){}

    public Resume(int resume_id, int stu_id, String resume_path, String resume_advice, String resume_advice_time) {
        this.resume_id = resume_id;
        this.stu_id = stu_id;
        this.resume_path = resume_path;
        this.resume_advice = resume_advice;
        this.resume_advice_time = resume_advice_time;
    }

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getResume_path() {
        return resume_path;
    }

    public void setResume_path(String resume_path) {
        this.resume_path = resume_path;
    }

    public String getResume_advice() {
        return resume_advice;
    }

    public void setResume_advice(String resume_advice) {
        this.resume_advice = resume_advice;
    }

    public String getResume_advice_time() {
        return resume_advice_time;
    }

    public void setResume_advice_time(String resume_advice_time) {
        this.resume_advice_time = resume_advice_time;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resume_id=" + resume_id +
                ", stu_id=" + stu_id +
                ", resume_path='" + resume_path + '\'' +
                ", resume_advice='" + resume_advice + '\'' +
                ", resume_advice_time='" + resume_advice_time + '\'' +
                '}';
    }
}
