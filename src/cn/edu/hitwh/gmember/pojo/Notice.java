package cn.edu.hitwh.gmember.pojo;

import java.util.Date;

public class Notice {
    private String noti_id;
    private String noti_title;
    private String noti_time;
    private String publisher;
    private String author_id;
    private String noti_content;
    private int noti_section_id;
    private int noti_readtimes;

    public Notice()  {}

    public Notice(String noti_id, String noti_title, String noti_time, String publisher, String author_id, String noti_content, int noti_section_id, int noti_readtimes) {
        this.noti_id = noti_id;
        this.noti_title = noti_title;
        this.noti_time = noti_time;
        this.publisher = publisher;
        this.author_id = author_id;
        this.noti_content = noti_content;
        this.noti_section_id = noti_section_id;
        this.noti_readtimes = noti_readtimes;
    }

    public String getNoti_id() {
        return noti_id;
    }

    public String getNoti_title() {
        return noti_title;
    }

    public String getNoti_time() {
        return noti_time;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getNoti_content() {
        return noti_content;
    }

    public int getNoti_section_id() {
        return noti_section_id;
    }

    public int getNoti_readtimes() {
        return noti_readtimes;
    }

    public void setNoti_id(String noti_id) {
        this.noti_id = noti_id;
    }

    public void setNoti_title(String noti_title) {
        this.noti_title = noti_title;
    }

    public void setNoti_time(String noti_time) {
        this.noti_time = noti_time;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setNoti_content(String noti_content) {
        this.noti_content = noti_content;
    }

    public void setNoti_section_id(int noti_section_id) {
        this.noti_section_id = noti_section_id;
    }

    public void setNoti_readtimes(int noti_readtimes) {
        this.noti_readtimes = noti_readtimes;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noti_id='" + noti_id + '\'' +
                ", noti_title='" + noti_title + '\'' +
                ", noti_time='" + noti_time + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author_id='" + author_id + '\'' +
                ", noti_content='" + noti_content + '\'' +
                ", noti_section_id=" + noti_section_id +
                ", noti_readtimes=" + noti_readtimes +
                '}';
    }
}
