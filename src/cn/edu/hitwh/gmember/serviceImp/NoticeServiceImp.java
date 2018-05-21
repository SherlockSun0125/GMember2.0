package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INoticeDao;
import cn.edu.hitwh.gmember.daoImp.NoticeDaoImp;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.service.INoticeService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class NoticeServiceImp implements INoticeService {
    INoticeDao noticeDao=new NoticeDaoImp();
    public Integer addNotice(Notice notice) {
        try{
            Integer notiid=noticeDao.addNotice(notice);
            return notiid;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Notice> findNoticesBySection(int sectionid, int currentPage) {
        try{
            return noticeDao.findNoticesBySection(sectionid,currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Notice> findAllNotices(int currentPage) {
        try{
            return noticeDao.findAllNotices(currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Notice findNoticeById(int noticeid) {
        try {
            return noticeDao.findNoticeById(noticeid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateNotice(Notice notice) {
        try {
            noticeDao.updateNotice(notice);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteNotice(int noti_id) {
        try {
            noticeDao.deleteNotice(noti_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer countAllNotices() {
        try {
            return noticeDao.countAllNotices();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
