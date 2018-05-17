package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.NewsSection;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INewsSectionService {
    public PageBean<NewsSection> findAllNewsSections();
}
