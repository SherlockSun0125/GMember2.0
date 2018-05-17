package cn.edu.hitwh.gmember.pojo;

public class NoticeSection {
    private int notice_section_id;
    private String notice_section_name;

    public NoticeSection(){}

    public NoticeSection(int notice_section_id, String notice_section_name){
        this.notice_section_id=notice_section_id;
        this.notice_section_name=notice_section_name;
    }

    public void setNotice_section_id(int notice_section_id) {
        this.notice_section_id = notice_section_id;
    }

    public void setNotice_section_name(String notice_section_name) {
        this.notice_section_name = notice_section_name;
    }

    public int getNotice_section_id() {
        return notice_section_id;
    }

    public String getNotice_section_name() {
        return notice_section_name;
    }

    @Override
    public String toString() {
        return "NoticeSection{" +
                "notice_section_id=" + notice_section_id +
                ", notice_section_name='" + notice_section_name + '\'' +
                '}';
    }
}
