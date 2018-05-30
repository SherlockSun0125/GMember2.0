package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    public Integer addCompany(Company company);
    public List<Company> findAllCompanies();
    public List<Company> adminFindAllCompanies(@Param("from") int from,@Param("pageSize") int pageSize);
    public Company findCompanyById(int com_id);
    public int countAllCompanies();
    public int countAllCompaniesByType(int comtype_id);
    public List<Company> adminFindCompaniesByType(@Param("comtype_id") int comtype_id,@Param("from") int from,@Param("pageSize") int pageSize);
    public void deleteCompany(int com_id);
    public void updateCompany(Company company);
}
