package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INoticeSectionDao;
import cn.edu.hitwh.gmember.daoImp.NoticeSectionDaoImp;
import cn.edu.hitwh.gmember.pojo.NoticeSection;
import cn.edu.hitwh.gmember.service.INoticeSectionService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class NoticeSectionServiceImp implements INoticeSectionService {
    INoticeSectionDao noticeSectionDao=new NoticeSectionDaoImp();


    @Override
    public PageBean<NoticeSection> findAllNoticeSections() {
        try{
            return noticeSectionDao.findAllNoticeSections();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
