package cn.edu.hitwh.gmember.pojo;

public class Course {
    private int course_id;//hou
    private String course_num;
    private int course_seq;
    private int stu_id;
    private String course_name;
    private String course_type;
    private String exam_type;
    private String course_place;
    private String course_weeks;
    private String course_time;
    private String exam_time;
    private double exam_grade;//hou
    private String teacher;
    private int isEnd;//hou

    public Course(){}

    public Course(int course_id, String course_num, int course_seq, int stu_id, String course_name, String course_type, String exam_type, String course_place, String course_weeks, String course_time, String exam_time, double exam_grade, String teacher, int isEnd) {
        this.course_id = course_id;
        this.course_num = course_num;
        this.course_seq = course_seq;
        this.stu_id = stu_id;
        this.course_name = course_name;
        this.course_type = course_type;
        this.exam_type = exam_type;
        this.course_place = course_place;
        this.course_weeks = course_weeks;
        this.course_time = course_time;
        this.exam_time = exam_time;
        this.exam_grade = exam_grade;
        this.teacher = teacher;
        this.isEnd = isEnd;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public int getCourse_seq() {
        return course_seq;
    }

    public void setCourse_seq(int course_seq) {
        this.course_seq = course_seq;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public String getCourse_place() {
        return course_place;
    }

    public void setCourse_place(String course_place) {
        this.course_place = course_place;
    }

    public String getCourse_weeks() {
        return course_weeks;
    }

    public void setCourse_weeks(String course_weeks) {
        this.course_weeks = course_weeks;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public double getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(double exam_grade) {
        this.exam_grade = exam_grade;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_num='" + course_num + '\'' +
                ", course_seq=" + course_seq +
                ", stu_id=" + stu_id +
                ", course_name='" + course_name + '\'' +
                ", course_type='" + course_type + '\'' +
                ", exam_type='" + exam_type + '\'' +
                ", course_place='" + course_place + '\'' +
                ", course_weeks='" + course_weeks + '\'' +
                ", course_time='" + course_time + '\'' +
                ", exam_time='" + exam_time + '\'' +
                ", exam_grade=" + exam_grade +
                ", teacher='" + teacher + '\'' +
                ", isEnd=" + isEnd +
                '}';
    }
}
