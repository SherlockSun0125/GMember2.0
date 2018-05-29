package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.ICompanyDao;
import cn.edu.hitwh.gmember.dao.IComtypeDao;
import cn.edu.hitwh.gmember.daoImp.CompanyDaoImp;
import cn.edu.hitwh.gmember.daoImp.ComtypeDaoImp;
import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.service.ICompanyService;
import cn.edu.hitwh.gmember.service.IComtypeService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class CompanyServiceImp implements ICompanyService {
    ICompanyDao companyDao=new CompanyDaoImp();
    @Override
    public Integer addCompany(Company company) {
        try{
            return companyDao.addCompany(company);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Company> findAllCompanys() {
        try{
            return companyDao.findAllCompanys();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Company findCompanyById(int com_id) {
        try{
            return companyDao.findCompanyById(com_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
