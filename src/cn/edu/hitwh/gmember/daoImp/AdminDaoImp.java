package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IAdminDao;
import cn.edu.hitwh.gmember.mapper.AdminMapper;
import cn.edu.hitwh.gmember.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class AdminDaoImp implements IAdminDao{
    @Override
    public Admin findAdmin(String admin_name, String admin_pwd) {
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session=null;
        Admin admin=null;
        try {
            reader = Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        admin = adminMapper.findAdmin(admin_name, admin_pwd);
        session.close();
        return admin;
    }

    @Override
    public String findAdminNameById(String admin_id) {
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session=null;
        try {
            reader = Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        String admin_name=adminMapper.findAdminNameById(admin_id);
        session.close();
        return admin_name;
    }
}
