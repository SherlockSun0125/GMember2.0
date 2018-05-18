package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IStugradeDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.StugradeDaoImp;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.pojo.Stugrade;
import cn.edu.hitwh.gmember.service.IStugradeService;
import cn.edu.hitwh.gmember.service.IStulevelService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class StugradeServiceImp implements IStugradeService {

    IStugradeDao stugradeDao=new StugradeDaoImp();

    @Override
    public PageBean<Stugrade> findAllStuGrades() {
        try{
            return stugradeDao.findAllStuGrades();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
