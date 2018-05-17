package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IComtypeDao;
import cn.edu.hitwh.gmember.daoImp.ComtypeDaoImp;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.service.IComtypeService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class ComtypeServiceImp implements IComtypeService {
    IComtypeDao comtypeDao=new ComtypeDaoImp();


    @Override
    public PageBean<Comtype> findAllComtypes() {
        try{
            return comtypeDao.findAllComtypes();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
