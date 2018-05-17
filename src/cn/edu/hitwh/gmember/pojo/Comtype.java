package cn.edu.hitwh.gmember.pojo;

public class Comtype {
    private int comtype_id;
    private String comtype_name;

    public Comtype() {
    }

    public Comtype(int comtype_id, String comtype_name) {
        this.comtype_id = comtype_id;
        this.comtype_name = comtype_name;
    }

    public void setComtype_id(int comtype_id) {
        this.comtype_id = comtype_id;
    }

    public void setcomtype_name(String comtype_name) {
        this.comtype_name = comtype_name;
    }

    public int getComtype_id() {
        return comtype_id;
    }

    public String getcomtype_name() {
        return comtype_name;
    }

    @Override
    public String toString() {
        return "Comtype{" +
                "comtype_id=" + comtype_id +
                ", comtype_name='" + comtype_name + '\'' +
                '}';
    }
}
