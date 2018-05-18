package cn.edu.hitwh.gmember.pojo;

public class Stugrade {
    private int stu_grade_id;
    private String stu_grade_name;

    public Stugrade(){}

    public Stugrade(int stu_grade_id, String stu_grade_name) {
        this.stu_grade_id = stu_grade_id;
        this.stu_grade_name = stu_grade_name;
    }

    public int getStu_grade_id() {
        return stu_grade_id;
    }

    public String getStu_grade_name() {
        return stu_grade_name;
    }

    public void setStu_grade_id(int stu_grade_id) {
        this.stu_grade_id = stu_grade_id;
    }

    public void setStu_grade_name(String stu_grade_name) {
        this.stu_grade_name = stu_grade_name;
    }

    @Override
    public String toString() {
        return "Stugrade{" +
                "stu_grade_id=" + stu_grade_id +
                ", stu_grade_name='" + stu_grade_name + '\'' +
                '}';
    }
}
