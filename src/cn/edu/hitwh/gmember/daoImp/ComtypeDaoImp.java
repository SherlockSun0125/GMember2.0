package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IComtypeDao;
import cn.edu.hitwh.gmember.mapper.ComtypeMapper;
import cn.edu.hitwh.gmember.mapper.DepartmentMapper;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class ComtypeDaoImp implements IComtypeDao{

    @Override
    public PageBean<Comtype> findAllComtypes() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Comtype> comtypePageBean=new PageBean<Comtype>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        ComtypeMapper comtypeMapper=session.getMapper(ComtypeMapper.class);
        List<Comtype> comtypeList=comtypeMapper.findAllComtypes();
        for(int i=0;i<comtypeList.size();i++){
            System.out.println("======"+comtypeList.get(i).toString());
        }
        comtypePageBean.setBeanList(comtypeList);
        return comtypePageBean;
    }
}
