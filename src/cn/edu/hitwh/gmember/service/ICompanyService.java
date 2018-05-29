package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ICompanyService {
    public Integer addCompany(Company company);
    public PageBean<Company> findAllCompanys();
    public Company findCompanyById(int com_id);
}
