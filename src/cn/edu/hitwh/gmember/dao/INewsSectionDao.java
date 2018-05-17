package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.NewsSection;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INewsSectionDao {
    public PageBean<NewsSection> findAllNewsSections();

}
