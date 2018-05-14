package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INoticeDao;
import cn.edu.hitwh.gmember.daoImp.NoticeDaoImp;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.service.INoticeService;

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
}
