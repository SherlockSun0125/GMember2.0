package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IEmployeeDao;
import cn.edu.hitwh.gmember.mapper.EmployeeMapper;
import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class EmployeeDaoImp implements IEmployeeDao{
    @Override
    public Employee findEmployee(String id, String pwd) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.findEmployee(id, pwd);
        session.close();
        return employee;
    }

    @Override
    public PageBean<Employee> findAllEmployeeDetail() {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        PageBean<Employee> employeePageBean=new PageBean<Employee>();
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList=employeeMapper.findAllEmployeeDetail();
        employeePageBean.setBeanList(employeeList);
        for(int i=0;i<employeePageBean.getBeanList().size();i++){
            System.out.println("employeePageBean.getBeanList().get("+i+"):"+employeePageBean.getBeanList().get(i));
        }
        session.close();
        return employeePageBean;
    }

    @Override
    public Employee findAllEmployeeById(int emp_id) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee=employeeMapper.findAllEmployeeById(emp_id);
        session.close();
        return employee;
    }
}
