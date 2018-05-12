package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Admin;

public interface IAdminDao {
    public Admin findAdmin(String admin_name,String admin_pwd);
}
