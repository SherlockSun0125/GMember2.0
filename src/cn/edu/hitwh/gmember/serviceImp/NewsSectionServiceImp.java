package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INewsSectionDao;
import cn.edu.hitwh.gmember.daoImp.NewsSectionDaoImp;
import cn.edu.hitwh.gmember.pojo.NewsSection;
import cn.edu.hitwh.gmember.service.INewsSectionService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class NewsSectionServiceImp implements INewsSectionService {
    INewsSectionDao newsSectionDao=new NewsSectionDaoImp();

    @Override
    public PageBean<NewsSection> findAllNewsSections() {
        try{
            return newsSectionDao.findAllNewsSections();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
