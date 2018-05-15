import cn.edu.hitwh.gmember.mapper.NewsMapper;
import cn.edu.hitwh.gmember.pojo.News;
import cn.edu.hitwh.gmember.tools.DateTools;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyNewsCountTest {
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
        NewsMapper newsMapper=session.getMapper(NewsMapper.class);
        int sectionid=2;
//        int num=newsMapper.countNewsBySection(sectionid);
        int num=newsMapper.countAllNews();
        System.out.println("新闻版块"+sectionid+"的新闻数量为："+num);
        session.close();
    }

}
