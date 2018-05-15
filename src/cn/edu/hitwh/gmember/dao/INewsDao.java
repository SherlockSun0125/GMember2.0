package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INewsDao {
    public Integer addNews(News news);
    public PageBean<News> findNewsBySection(int sectionid, int currentPage);
    public PageBean<News> findAllNews(int currentPage);
    public News findNewsById(int new_id);
}
