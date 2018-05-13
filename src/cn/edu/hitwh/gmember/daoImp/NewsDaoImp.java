package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.INewsDao;
import cn.edu.hitwh.gmember.mapper.NewsMapper;
import cn.edu.hitwh.gmember.pojo.News;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class NewsDaoImp implements INewsDao {

    @Override
    public void addNews(News news) {
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
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);
        newsMapper.addNews(news);
        session.close();
    }
}
