package cn.edu.hitwh.gmember.pojo;

public class Student {
    private int stu_id;
    private String stu_num;
    private String stu_name;
    private String stu_pwd;
    private String stu_sex;
    private int stu_age;
    private int emp_id;
    private int dep_id;
    private String stu_phone;
    private String stu_mail;
    private int stu_level_id;
    private String stu_note;
    private String stu_major;
    private String stu_english;
    private int stu_grade_id;

    public Student(){}

    public Student(int stu_id, String stu_num, String stu_name, String stu_pwd, String stu_sex, int stu_age, int emp_id, int dep_id, String stu_phone, String stu_mail, int stu_level_id, String stu_note, String stu_major, String stu_english, int stu_grade_id) {
        this.stu_id = stu_id;
        this.stu_num = stu_num;
        this.stu_name = stu_name;
        this.stu_pwd = stu_pwd;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.emp_id = emp_id;
        this.dep_id = dep_id;
        this.stu_phone = stu_phone;
        this.stu_mail = stu_mail;
        this.stu_level_id = stu_level_id;
        this.stu_note = stu_note;
        this.stu_major = stu_major;
        this.stu_english = stu_english;
        this.stu_grade_id = stu_grade_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public String getStu_num() {
        return stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public int getStu_age() {
        return stu_age;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public String getStu_mail() {
        return stu_mail;
    }

    public int getStu_level_id() {
        return stu_level_id;
    }

    public String getStu_note() {
        return stu_note;
    }

    public String getStu_major() {
        return stu_major;
    }

    public String getStu_english() {
        return stu_english;
    }

    public int getStu_grade_id() {
        return stu_grade_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public void setStu_mail(String stu_mail) {
        this.stu_mail = stu_mail;
    }

    public void setStu_level_id(int stu_level_id) {
        this.stu_level_id = stu_level_id;
    }

    public void setStu_note(String stu_note) {
        this.stu_note = stu_note;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }

    public void setStu_english(String stu_english) {
        this.stu_english = stu_english;
    }

    public void setStu_grade_id(int stu_grade_id) {
        this.stu_grade_id = stu_grade_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_age=" + stu_age +
                ", emp_id=" + emp_id +
                ", dep_id=" + dep_id +
                ", stu_phone='" + stu_phone + '\'' +
                ", stu_mail='" + stu_mail + '\'' +
                ", stu_level_id=" + stu_level_id +
                ", stu_note='" + stu_note + '\'' +
                ", stu_major='" + stu_major + '\'' +
                ", stu_english='" + stu_english + '\'' +
                ", stu_grade_id=" + stu_grade_id +
                '}';
    }
}
