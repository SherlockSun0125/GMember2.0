package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface ICompanyDao {
    public Integer addCompany(Company company);
    public PageBean<Company> findAllCompanys();
    public Company findCompanyById(int com_id);

}
