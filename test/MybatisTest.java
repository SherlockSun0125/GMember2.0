import cn.edu.hitwh.gmember.mapper.AdminMapper;
import cn.edu.hitwh.gmember.mapper.NewsMapper;
import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.DateTools;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

public class MybatisTest {
    public static void main(String[] args){
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try {
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();

        News news = new News();
//        news.setNews_id(121212);
//        设置名称
//        news.setNews_title(req.getParameter("title"));
        news.setNews_title("这是新闻");
        System.out.println("title:"+news.getNews_title());
//        设置时间
        Date date=new Date();
        DateTools dateTools=new DateTools();
        news.setNews_time(dateTools.date2Str(date));
        System.out.println("date:"+news.getNews_time());
//        设置发布人
//        news.setPublisher(req.getParameter("author"));
        news.setPublisher("孙鹏重");
        System.out.println("author:"+news.getPublisher());
//      设置作者id
        news.setAuthor_id("0001");
        System.out.println("adminid:"+news.getAuthor_id());
//      设置内容
        String content="新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容，新闻内容";
        news.setNews_content(content);
        System.out.println("content:"+news.getNews_content());
//        阅读次数
        news.setNews_readtimes(1000);
        System.out.println("readtimes:"+news.getNews_readtimes());
//      版块id
        news.setNews_section_id(1);
        System.out.println("section:"+news.getNews_section_id());

        System.out.println("news.toString()="+news.toString());

        NewsMapper newsMapper=session.getMapper(NewsMapper.class);

        Integer id=newsMapper.addNews(news);

        if(id!= null) {
            System.out.println("+++++++++++++++++++++++++" + id.intValue());
        }else{
            System.out.println("+++++++++++++++++++++++++ 插入失败");
        }
        session.commit();
        session.close();
    }
}
