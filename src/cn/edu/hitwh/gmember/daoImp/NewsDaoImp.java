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
        pageBean.setTotalRecords(totalRecords);
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
//        System.out.println("currentpage="+currentPage+";from="+from+";pageSize="+pageSize);
        List<News> newsList= newsMapper.findAllNews(from,pageSize);

        pageBean.setBeanList(newsList);
//        将总的新闻数存入pageBean
        pageBean.setTotalRecords(totalRecords);
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
        //先更新浏览次数的值
//        newsMapper.updateReadtimes(news_id);
        //再取数据
        news=newsMapper.findNewsById(news_id);
        int readtimes=news.getNews_readtimes();
        try {
            newsMapper.updateReadtimes(news_id, readtimes + 1);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            news=newsMapper.findNewsById(news_id);
            session.close();
        }
        return news;
    }

    @Override
    public void updateNews(News news) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);

        try {
            System.out.println("dao层获取到的新闻信息为："+news.toString());
            newsMapper.updateNews(news);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteNews(int news_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);

        try {
            newsMapper.deleteNews(news_id);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Integer countAllNews() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);

        int newsNum=newsMapper.countAllNews();
        return newsNum;
    }
}
