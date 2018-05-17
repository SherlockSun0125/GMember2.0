package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.NoticeSection;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INoticeSectionDao {
    public PageBean<NoticeSection> findAllNoticeSections();

}
