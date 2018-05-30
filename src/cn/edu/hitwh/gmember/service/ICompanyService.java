package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.tools.PageBean;

import java.util.List;

public interface ICompanyService {
    public Integer addCompany(Company company);
    public PageBean<Company> findAllCompanies();
    public PageBean<Company> adminFindAllCompanies(int currentPage);
    public Company findCompanyById(int com_id);
    public int countAllCompanies();
    public int countAllCompaniesByType(int comtype_id);
    public PageBean<Company> adminFindCompaniesByType(int comtype_id,int currentPage);
    public void deleteCompany(int com_id);
    public void updateCompany(Company company);
}
