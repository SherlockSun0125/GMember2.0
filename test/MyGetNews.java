import cn.edu.hitwh.gmember.mapper.NewsMapper;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.print.Book;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.NEWS_PAGE_SIZE;

public class MyGetNews {
    public static void main(String[] args){
        int currentPage=2;
        int sectionid=1;
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        PageBean<News> pageBean = null;
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
        System.out.println("该类总个数"+totalRecords);
        List<News> newsList = newsMapper.findNewsBySection(sectionid, from,pageSize);
        for(News news:newsList){
            System.out.println("获得id:"+news.getNews_id());
            System.out.println("-----------------------------------");
        }
        pageBean.setBeanList(newsList);
        session.close();
    }
}
