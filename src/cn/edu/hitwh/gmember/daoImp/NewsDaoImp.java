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
    public Integer addNews(News news) {
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session=null;
        Integer newsid=null;
        try {
            reader= Resources.getResourceAsReader(resource);

            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            NewsMapper newsMapper=session.getMapper(NewsMapper.class);
            newsid=newsMapper.addNews(news);
            session.commit();
        }catch (IOException e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return newsid;
    }
}
