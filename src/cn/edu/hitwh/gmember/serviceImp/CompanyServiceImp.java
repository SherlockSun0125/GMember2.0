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

import java.util.List;

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
    public PageBean<Company> findAllCompanies() {
        try{
            return companyDao.findAllCompanies();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Company> adminFindAllCompanies(int currentPage) {
        try{
            return companyDao.adminFindAllCompanies(currentPage);
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

    @Override
    public int countAllCompanies() {
        try{
            return companyDao.countAllCompanies();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countAllCompaniesByType(int comtype_id) {
        try{
            return companyDao.countAllCompaniesByType(comtype_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Company> adminFindCompaniesByType(int comtype_id,int currentPage) {
        try{
            return companyDao.adminFindCompaniesByType(comtype_id,currentPage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCompany(int com_id) {
        try{
            companyDao.deleteCompany(com_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCompany(Company company) {
        try{
            companyDao.updateCompany(company);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
