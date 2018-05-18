package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.INewsDao;
import cn.edu.hitwh.gmember.daoImp.NewsDaoImp;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.service.INewsService;
import cn.edu.hitwh.gmember.tools.PageBean;

import java.sql.SQLException;

public class NewsServiceImp implements INewsService {
    INewsDao newsDao=new NewsDaoImp();
    public Integer addNews(News news) {
        try{
            Integer newsid=newsDao.addNews(news);
            return newsid;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public PageBean<News> findNewsBySection(int sectionid, int currentPage) {
        try {
            return newsDao.findNewsBySection(sectionid, currentPage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<News> findAllNews(int currentPage) {
        try {
            return newsDao.findAllNews(currentPage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public News findNewsById(int news_id) {
        try{
            return newsDao.findNewsById(news_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateNews(News news) {
        try{
            newsDao.updateNews(news);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteNews(int news_id) {
        try{
            newsDao.deleteNews(news_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
