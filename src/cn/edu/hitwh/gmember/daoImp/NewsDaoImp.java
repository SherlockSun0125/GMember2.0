package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.INewsDao;
import cn.edu.hitwh.gmember.mapper.NewsMapper;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.NEWS_PAGE_SIZE;

public class NewsDaoImp implements INewsDao {

//    增加新闻
    public Integer addNews(News news) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        Integer newsid = null;
        try {
            reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            NewsMapper newsMapper = session.getMapper(NewsMapper.class);
            newsid = newsMapper.addNews(news);
            session.commit();
        } catch (IOException e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return newsid;
    }

//    按照分类查找新闻
    public PageBean<News> findNewsBySection(int sectionid, int currentPage) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        PageBean<News> pageBean = new PageBean<News>();
        int pageSize=NEWS_PAGE_SIZE;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        NewsMapper newsMapper = session.getMapper(NewsMapper.class);
        int totalRecords=newsMapper.countNewsBySection(sectionid);
        int from=(currentPage - 1) * pageSize;// 当前页首行记录的下标
        List<News> newsList= newsMapper.findNewsBySection(sectionid, from,pageSize);
        for(News news:newsList){
            System.out.println("通过newsList获得id:"+news.getNews_id());
        }
        System.out.println("-----------------------------------");
        pageBean.setBeanList(newsList);
        pageBean.setTotalRecods(totalRecords);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        for(News news:pageBean.getBeanList()){
            System.out.println("通过pageBean获得id:"+news.getNews_id());
        }
        System.out.println("-----------------------------------");
        session.close();
        return pageBean;
    }


//    找到所有新闻
    public PageBean<News> findAllNews(int currentPage) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        PageBean<News> pageBean = new PageBean<News>();
        int pageSize=NEWS_PAGE_SIZE;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        NewsMapper newsMapper = session.getMapper(NewsMapper.class);
        int totalRecords=newsMapper.countAllNews();
        int from=(currentPage - 1) * pageSize;// 当前页首行记录的下标
        System.out.println("currentpage="+currentPage+";from="+from+";pageSize="+pageSize);
        List<News> newsList= newsMapper.findAllNews(from,pageSize);
//        for(News news:newsList){
//            System.out.println("通过newsList获得id:"+news.getNews_id());
//        }
//        System.out.println("-----------------------------------");

//        将获取的新闻list存入pageBean
        pageBean.setBeanList(newsList);
//        将总的新闻数存入pageBean
        pageBean.setTotalRecods(totalRecords);
//        将当前页码存入pageBean
        pageBean.setCurrentPage(currentPage);
//        将页面新闻数存入pageBean
        pageBean.setPageSize(pageSize);

//        for(News news:pageBean.getBeanList()){
//            System.out.println("通过pageBean获得id:"+news.getNews_id());
//        }
//        System.out.println("-----------------------------------");
        session.close();
        return pageBean;
    }

//  通过id查找news
    public News findNewsById(int news_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        News news=new News();
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);
        news=newsMapper.findNewsById(news_id);
        session.close();
        return news;
    }


}
