package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Admin;

public interface IAdminService {
    public Admin login(Admin admin);
    public String findAdminNameById(String admin_id);
    public void updateAdminPwd(String admin_id,String admin_pwd);

}
