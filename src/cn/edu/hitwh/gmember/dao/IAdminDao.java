package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Admin;

public interface IAdminDao {
    public Admin findAdmin(String admin_name,String admin_pwd);
    public String findAdminNameById(String admin_id);
    public void updateAdminPwd(String admin_id,String admin_pwd);
}
