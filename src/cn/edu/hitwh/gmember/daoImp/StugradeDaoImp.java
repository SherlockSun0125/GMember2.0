package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IStugradeDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.mapper.StugradeMapper;
import cn.edu.hitwh.gmember.mapper.StulevelMapper;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.pojo.Stugrade;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class StugradeDaoImp implements IStugradeDao{

    @Override
    public PageBean<Stugrade> findAllStuGrades() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Stugrade> stugradePageBean=new PageBean<Stugrade>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        StugradeMapper stugradeMapper=session.getMapper(StugradeMapper.class);

        List<Stugrade> stugrades=stugradeMapper.findAllStuGrades();

        stugradePageBean.setBeanList(stugrades);
        return stugradePageBean;
    }
}
