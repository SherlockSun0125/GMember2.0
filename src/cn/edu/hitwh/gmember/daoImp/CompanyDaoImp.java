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
    public PageBean<Company> findAllCompanys() {
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

        List<Company> companyList=companyMapper.findAllCompanys();

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
}
