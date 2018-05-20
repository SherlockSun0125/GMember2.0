package cn.edu.hitwh.gmember.pojo;

public class StuLog {
    private String stu_log_id;
    private int stu_id;
    private String stu_log_title;
    private String stu_log_content;
    private String stu_log_time;
    private int stu_level_id;
    private String tea_feedback;
    private int tea_status;
    private String emp_feedback;
    private int emp_status;


    public StuLog() {
    }

    public StuLog(String stu_log_id, int stu_id, String stu_log_title, String stu_log_content, String stu_log_time, int stu_level_id, String tea_feedback, int tea_status, String emp_feedback, int emp_status) {
        this.stu_log_id = stu_log_id;
        this.stu_id = stu_id;
        this.stu_log_title = stu_log_title;
        this.stu_log_content = stu_log_content;
        this.stu_log_time = stu_log_time;
        this.stu_level_id = stu_level_id;
        this.tea_feedback = tea_feedback;
        this.tea_status = tea_status;
        this.emp_feedback = emp_feedback;
        this.emp_status = emp_status;
    }

    public String getStu_log_id() {
        return stu_log_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public String getStu_log_title() {
        return stu_log_title;
    }

    public String getStu_log_content() {
        return stu_log_content;
    }

    public String getStu_log_time() {
        return stu_log_time;
    }

    public int getStu_level_id() {
        return stu_level_id;
    }

    public String getTea_feedback() {
        return tea_feedback;
    }

    public int getTea_status() {
        return tea_status;
    }

    public String getEmp_feedback() {
        return emp_feedback;
    }

    public int getEmp_status() {
        return emp_status;
    }

    public void setStu_log_id(String stu_log_id) {
        this.stu_log_id = stu_log_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void setStu_log_title(String stu_log_title) {
        this.stu_log_title = stu_log_title;
    }

    public void setStu_log_content(String stu_log_content) {
        this.stu_log_content = stu_log_content;
    }

    public void setStu_log_time(String stu_log_time) {
        this.stu_log_time = stu_log_time;
    }

    public void setStu_level_id(int stu_level_id) {
        this.stu_level_id = stu_level_id;
    }

    public void setTea_feedback(String tea_feedback) {
        this.tea_feedback = tea_feedback;
    }

    public void setTea_status(int tea_status) {
        this.tea_status = tea_status;
    }

    public void setEmp_feedback(String emp_feedback) {
        this.emp_feedback = emp_feedback;
    }

    public void setEmp_status(int emp_status) {
        this.emp_status = emp_status;
    }

    @Override
    public String toString() {
        return "StuLog{" +
                "stu_log_id='" + stu_log_id + '\'' +
                ", stu_id=" + stu_id +
                ", stu_log_title='" + stu_log_title + '\'' +
                ", stu_log_content='" + stu_log_content + '\'' +
                ", stu_log_time='" + stu_log_time + '\'' +
                ", stu_level_id=" + stu_level_id +
                ", tea_feedback='" + tea_feedback + '\'' +
                ", tea_status=" + tea_status +
                ", emp_feedback='" + emp_feedback + '\'' +
                ", emp_status=" + emp_status +
                '}';
    }
}
