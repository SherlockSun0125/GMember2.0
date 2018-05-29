package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Company;

import java.util.List;

public interface CompanyMapper {
    public Integer addCompany(Company company);
    public List<Company> findAllCompanys();
    public Company findCompanyById(int com_id);
}
