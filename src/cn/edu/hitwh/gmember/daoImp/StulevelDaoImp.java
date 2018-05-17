package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IDepartmentDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.mapper.DepartmentMapper;
import cn.edu.hitwh.gmember.mapper.StulevelMapper;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class StulevelDaoImp implements IStulevelDao{

    @Override
    public PageBean<StuLevel> findAllStuLevels() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<StuLevel> stuLevelPageBean=new PageBean<StuLevel>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StulevelMapper stulevelMapper=session.getMapper(StulevelMapper.class);

        List<StuLevel> stuLevels=stulevelMapper.findAllStuLevels();

        stuLevelPageBean.setBeanList(stuLevels);
        return stuLevelPageBean;
    }
}
