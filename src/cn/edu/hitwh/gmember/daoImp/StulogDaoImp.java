package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IStulogDao;
import cn.edu.hitwh.gmember.mapper.StulogMapper;
import cn.edu.hitwh.gmember.pojo.StuLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class StulogDaoImp implements IStulogDao{

    @Override
    public Integer addStuLog(StuLog stuLog) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Integer stu_log_id=null;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulogMapper stulogMapper=session.getMapper(StulogMapper.class);
        try {
            stu_log_id=stulogMapper.addStuLog(stuLog);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
            return stu_log_id;
        }
    }
}
