package cn.edu.hitwh.gmember.pojo;

public class News {
    private Integer news_id;
    private String news_time;
    private String publisher;
    private String author_id;
    private String news_title;
    private String news_content;
    private int news_section_id;
    private int news_readtimes;

    public News(){}

    public News(Integer news_id, String news_time, String publisher, String author_id, String news_title, String news_content, int news_section_id, int news_readtimes) {
        this.news_id = news_id;
        this.news_time = news_time;
        this.publisher = publisher;
        this.author_id = author_id;
        this.news_title = news_title;
        this.news_content = news_content;
        this.news_section_id = news_section_id;
        this.news_readtimes = news_readtimes;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public String getNews_time() {
        return news_time;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public int getNews_section_id() {
        return news_section_id;
    }

    public int getNews_readtimes() {
        return news_readtimes;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public void setNews_section_id(int news_section_id) {
        this.news_section_id = news_section_id;
    }

    public void setNews_readtimes(int news_readtimes) {
        this.news_readtimes = news_readtimes;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", news_time='" + news_time + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author_id='" + author_id + '\'' +
                ", news_title='" + news_title + '\'' +
                ", news_content='" + news_content + '\'' +
                ", news_section_id=" + news_section_id +
                ", news_readtimes=" + news_readtimes +
                '}';
    }
}
