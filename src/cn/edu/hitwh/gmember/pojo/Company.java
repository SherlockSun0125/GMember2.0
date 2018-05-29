package cn.edu.hitwh.gmember.pojo;

public class Company {
    private int com_id;
    private String com_name;
    private String com_info;
    private int comtype_id;
    private String com_img;
    private String com_time;

    public Company() {
    }

    public Company(int com_id, String com_name, String com_info, int comtype_id, String com_img, String com_time) {
        this.com_id = com_id;
        this.com_name = com_name;
        this.com_info = com_info;
        this.comtype_id = comtype_id;
        this.com_img = com_img;
        this.com_time = com_time;
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_info() {
        return com_info;
    }

    public void setCom_info(String com_info) {
        this.com_info = com_info;
    }

    public int getComtype_id() {
        return comtype_id;
    }

    public void setComtype_id(int comtype_id) {
        this.comtype_id = comtype_id;
    }

    public String getCom_img() {
        return com_img;
    }

    public void setCom_img(String com_img) {
        this.com_img = com_img;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    @Override
    public String toString() {
        return "Company{" +
                "com_id=" + com_id +
                ", com_name='" + com_name + '\'' +
                ", com_info='" + com_info + '\'' +
                ", comtype_id=" + comtype_id +
                ", com_img='" + com_img + '\'' +
                ", com_time='" + com_time + '\'' +
                '}';
    }
}
