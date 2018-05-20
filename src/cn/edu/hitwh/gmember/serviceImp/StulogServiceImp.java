package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStulogDao;
import cn.edu.hitwh.gmember.daoImp.StulogDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLog;
import cn.edu.hitwh.gmember.service.IStulogService;

public class StulogServiceImp implements IStulogService {
    IStulogDao stulogDao=new StulogDaoImp();

    @Override
    public Integer addStuLog(StuLog stuLog) {
        try{
            return stulogDao.addStuLog(stuLog);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
