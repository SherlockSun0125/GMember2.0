package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INewsService {
    public Integer addNews(News news);
    public PageBean<News> findNewsBySection(int sectionid,int currentPage);

}
