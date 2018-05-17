package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IComtypeDao;
import cn.edu.hitwh.gmember.dao.INoticeSectionDao;
import cn.edu.hitwh.gmember.mapper.ComtypeMapper;
import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.mapper.NoticeSectionMapper;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.pojo.NoticeSection;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class NoticeSectionDaoImp implements INoticeSectionDao{

    @Override
    public PageBean<NoticeSection> findAllNoticeSections() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<NoticeSection> noticeSectionPageBean=new PageBean<NoticeSection>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();


        NoticeSectionMapper noticeSectionMapper=session.getMapper(NoticeSectionMapper.class);
        List<NoticeSection> noticeSections=noticeSectionMapper.findAllNoticeSections();
        for(int i=0;i<noticeSections.size();i++){
            System.out.println("======"+noticeSections.get(i).toString());
        }
        noticeSectionPageBean.setBeanList(noticeSections);
        return noticeSectionPageBean;
    }
}
