package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.INewsSectionDao;
import cn.edu.hitwh.gmember.mapper.NewsSectionMapper;
import cn.edu.hitwh.gmember.pojo.NewsSection;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class NewsSectionDaoImp implements INewsSectionDao{

    @Override
    public PageBean<NewsSection> findAllNewsSections() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<NewsSection> newsSectionPageBean=new PageBean<NewsSection>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        NewsSectionMapper newsMapper=session.getMapper(NewsSectionMapper.class);
        List<NewsSection> newsSections=newsMapper.findAllNewsSections();
//        for(int i=0;i<newsSections.size();i++){
//            System.out.println("======"+newsSections.get(i).toString());
//        }
        newsSectionPageBean.setBeanList(newsSections);
        return newsSectionPageBean;
    }
}
