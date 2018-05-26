package cn.edu.hitwh.gmember.pojo;

public class Project {
    private int project_id;
    private int stu_id;
    private String project_name;
    private String course;//所属课程，可为空
    private String teacher;//负责教师，可为空
    private String project_place;
    private String project_start_time;
    private String project_stop_time;
    private String project_member;
    private String project_about;
    private int stu_level_id;
    private String start_paper;
    private String start_paperF;
    private String mid_paper;
    private String mid_paperF;
    private String end_paper;
    private String end_paperF;
    private int isEnd;
    private String project_grade;//ABCDE
    private String file_desc;
    private String file_path;

    public Project(){}

    public Project(int project_id, int stu_id, String project_name, String course, String teacher, String project_place, String project_start_time, String project_stop_time, String project_member, String project_about, int stu_level_id, String start_paper, String start_paperF, String mid_paper, String mid_paperF, String end_paper, String end_paperF, int isEnd, String project_grade, String file_desc, String file_path) {
        this.project_id = project_id;
        this.stu_id = stu_id;
        this.project_name = project_name;
        this.course = course;
        this.teacher = teacher;
        this.project_place = project_place;
        this.project_start_time = project_start_time;
        this.project_stop_time = project_stop_time;
        this.project_member = project_member;
        this.project_about = project_about;
        this.stu_level_id = stu_level_id;
        this.start_paper = start_paper;
        this.start_paperF = start_paperF;
        this.mid_paper = mid_paper;
        this.mid_paperF = mid_paperF;
        this.end_paper = end_paper;
        this.end_paperF = end_paperF;
        this.isEnd = isEnd;
        this.project_grade = project_grade;
        this.file_desc = file_desc;
        this.file_path = file_path;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getProject_place() {
        return project_place;
    }

    public void setProject_place(String project_place) {
        this.project_place = project_place;
    }

    public String getProject_start_time() {
        return project_start_time;
    }

    public void setProject_start_time(String project_start_time) {
        this.project_start_time = project_start_time;
    }

    public String getProject_stop_time() {
        return project_stop_time;
    }

    public void setProject_stop_time(String project_stop_time) {
        this.project_stop_time = project_stop_time;
    }

    public String getProject_member() {
        return project_member;
    }

    public void setProject_member(String project_member) {
        this.project_member = project_member;
    }

    public String getProject_about() {
        return project_about;
    }

    public void setProject_about(String project_about) {
        this.project_about = project_about;
    }

    public int getStu_level_id() {
        return stu_level_id;
    }

    public void setStu_level_id(int stu_level_id) {
        this.stu_level_id = stu_level_id;
    }

    public String getStart_paper() {
        return start_paper;
    }

    public void setStart_paper(String start_paper) {
        this.start_paper = start_paper;
    }

    public String getStart_paperF() {
        return start_paperF;
    }

    public void setStart_paperF(String start_paperF) {
        this.start_paperF = start_paperF;
    }

    public String getMid_paper() {
        return mid_paper;
    }

    public void setMid_paper(String mid_paper) {
        this.mid_paper = mid_paper;
    }

    public String getMid_paperF() {
        return mid_paperF;
    }

    public void setMid_paperF(String mid_paperF) {
        this.mid_paperF = mid_paperF;
    }

    public String getEnd_paper() {
        return end_paper;
    }

    public void setEnd_paper(String end_paper) {
        this.end_paper = end_paper;
    }

    public String getEnd_paperF() {
        return end_paperF;
    }

    public void setEnd_paperF(String end_paperF) {
        this.end_paperF = end_paperF;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    public String getProject_grade() {
        return project_grade;
    }

    public void setProject_grade(String project_grade) {
        this.project_grade = project_grade;
    }

    public String getFile_desc() {
        return file_desc;
    }

    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", stu_id=" + stu_id +
                ", project_name='" + project_name + '\'' +
                ", course='" + course + '\'' +
                ", teacher='" + teacher + '\'' +
                ", project_place='" + project_place + '\'' +
                ", project_start_time='" + project_start_time + '\'' +
                ", project_stop_time='" + project_stop_time + '\'' +
                ", project_member='" + project_member + '\'' +
                ", project_about='" + project_about + '\'' +
                ", stu_level_id=" + stu_level_id +
                ", start_paper='" + start_paper + '\'' +
                ", start_paperF='" + start_paperF + '\'' +
                ", mid_paper='" + mid_paper + '\'' +
                ", mid_paperF='" + mid_paperF + '\'' +
                ", end_paper='" + end_paper + '\'' +
                ", end_paperF='" + end_paperF + '\'' +
                ", isEnd=" + isEnd +
                ", project_grade='" + project_grade + '\'' +
                ", file_desc='" + file_desc + '\'' +
                ", file_path='" + file_path + '\'' +
                '}';
    }
}
