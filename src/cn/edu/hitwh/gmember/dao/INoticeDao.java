package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INoticeDao {
    public Integer addNotice(Notice notice);
    public PageBean<Notice> findNoticesBySection(int sectionid, int currentPage);
    public PageBean<Notice> findAllNotices(int currentPage);
    public Notice findNoticeById(int noticeid);
}
