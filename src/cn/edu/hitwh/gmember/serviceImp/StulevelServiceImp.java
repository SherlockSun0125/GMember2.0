package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.service.IStulevelService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class StulevelServiceImp implements IStulevelService {
    IStulevelDao stulevelDao=new StulevelDaoImp();


    @Override
    public PageBean<StuLevel> findAllStuLevels() {
        try{
            return stulevelDao.findAllStuLevels();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
