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
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            AdminMapper adminMapper = session.getMapper(AdminMapper.class);
            admin = adminMapper.findAdmin(admin_name, admin_pwd);
//        System.out.println("id为"+id+"的教师信息为"+teacher.toString());
            session.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return admin;
    }
}
