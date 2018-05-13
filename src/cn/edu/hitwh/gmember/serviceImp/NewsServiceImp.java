package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INewsDao;
import cn.edu.hitwh.gmember.daoImp.NewsDaoImp;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.service.INewsService;

public class NewsServiceImp implements INewsService {
    INewsDao newsDao=new NewsDaoImp();
    public void addNews(News news) {
        try{
            newsDao.addNews(news);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
