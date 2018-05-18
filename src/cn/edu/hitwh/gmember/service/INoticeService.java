package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface INoticeService {
    public Integer addNotice(Notice notice);
    public PageBean<Notice> findNoticesBySection(int sectionid, int currentPage);
    public PageBean<Notice> findAllNotices(int currentPage);
    public Notice findNoticeById(int noticeid);
    public void updateNotice(Notice notice);
    public void deleteNotice(int noti_id);
}
