package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.INewsDao;
import cn.edu.hitwh.gmember.dao.INoticeDao;
import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.pojo.Notice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class NoticeDaoImp implements INoticeDao {

    public Integer addNotice(Notice notice) {
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session=null;
        Integer notiid=null;
        try {
            reader= Resources.getResourceAsReader(resource);

            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            NoticeMapper noticeMapper=session.getMapper(NoticeMapper.class);
            notiid=noticeMapper.addNotice(notice);
            session.commit();
        }catch (IOException e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return notiid;
    }
}
