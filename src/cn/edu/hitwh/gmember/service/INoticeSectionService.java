package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.NoticeSection;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INoticeSectionService {
    public PageBean<NoticeSection> findAllNoticeSections();
}
