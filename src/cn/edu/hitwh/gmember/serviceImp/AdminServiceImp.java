package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IAdminDao;
import cn.edu.hitwh.gmember.daoImp.AdminDaoImp;
import cn.edu.hitwh.gmember.pojo.Admin;
import cn.edu.hitwh.gmember.service.IAdminService;

public class AdminServiceImp implements IAdminService {
    IAdminDao adminDao=new AdminDaoImp();
    @Override
    public Admin login(Admin admin) {
        try{
            return adminDao.findAdmin(admin.getAdmin_id(),admin.getAdmin_password());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
