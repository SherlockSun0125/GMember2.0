package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.ICompanyDao;
import cn.edu.hitwh.gmember.dao.IComtypeDao;
import cn.edu.hitwh.gmember.mapper.CompanyMapper;
import cn.edu.hitwh.gmember.mapper.ComtypeMapper;
import cn.edu.hitwh.gmember.pojo.Company;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.COMPANY_PAGE_SIZE;

public class CompanyDaoImp implements ICompanyDao{
    public Integer addCompany(Company company) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);
        System.out.println("来自servlet层的问候company.toString()："+company.toString());

        Integer comid=null;

        try{
            comid=companyMapper.addCompany(company);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return comid;
    }

    @Override
    public PageBean<Company> findAllCompanies() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Company> companyPageBean=new PageBean<Company>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        List<Company> companyList=companyMapper.findAllCompanies();

        companyPageBean.setBeanList(companyList);

        session.close();
        return companyPageBean;
    }

    @Override
    public Company findCompanyById(int com_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        Company company=new Company();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);
        company=companyMapper.findCompanyById(com_id);

        session.close();
        return company;
    }

    @Override
    public int countAllCompanies() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        int totalRecords=companyMapper.countAllCompanies();

        session.close();
        return totalRecords;
    }

    @Override
    public int countAllCompaniesByType(int comtype_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        int typeRecords=companyMapper.countAllCompaniesByType(comtype_id);

        session.close();
        return typeRecords;
    }

    @Override
    public PageBean<Company> adminFindCompaniesByType(int comtype_id,int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Company> companyPageBean=new PageBean<Company>();
        int pageSize=COMPANY_PAGE_SIZE;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        int totalRecords=companyMapper.countAllCompaniesByType(comtype_id);
        int from=(currentPage-1)*pageSize;

        List<Company> companyList=companyMapper.adminFindCompaniesByType(comtype_id,from,pageSize);

        companyPageBean.setTotalRecords(totalRecords);
        companyPageBean.setCurrentPage(currentPage);
        companyPageBean.setPageSize(pageSize);
        companyPageBean.setTotalPages(companyPageBean.getTotalPages());
        companyPageBean.setBeanList(companyList);

        session.close();
        return companyPageBean;
    }

    public PageBean<Company> adminFindAllCompanies(int currentPage) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Company> companyPageBean=new PageBean<Company>();
        int pageSize=COMPANY_PAGE_SIZE;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        int totalRecords=companyMapper.countAllCompanies();
        int from=(currentPage-1)*pageSize;

        List<Company> companyList=companyMapper.adminFindAllCompanies(from,pageSize);

        companyPageBean.setTotalRecords(totalRecords);
        companyPageBean.setCurrentPage(currentPage);
        companyPageBean.setPageSize(pageSize);
        companyPageBean.setTotalPages(companyPageBean.getTotalPages());
        companyPageBean.setBeanList(companyList);

        session.close();
        return companyPageBean;
    }

    @Override
    public void deleteCompany(int com_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        try{
            companyMapper.deleteCompany(com_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateCompany(Company company) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        CompanyMapper companyMapper=session.getMapper(CompanyMapper.class);

        try{
            companyMapper.updateCompany(company);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
