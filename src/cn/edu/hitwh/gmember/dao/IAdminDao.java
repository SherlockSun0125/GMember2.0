package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.mapper.AdminMapper;
import cn.edu.hitwh.gmember.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public interface IAdminDao {
    public Admin findAdmin(String admin_name,String admin_pwd);
}
