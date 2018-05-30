package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IEmployeeDao;
import cn.edu.hitwh.gmember.mapper.EmployeeMapper;
import cn.edu.hitwh.gmember.mapper.StudentMapper;
import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.EMPLOYEE_PAGE_SIZE;


public class EmployeeDaoImp implements IEmployeeDao{
    @Override
    public Employee findEmployee(String phone, String pwd) {
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
        Employee employee = employeeMapper.findEmployee(phone, pwd);
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
//        for(int i=0;i<employeePageBean.getBeanList().size();i++){
//            System.out.println("employeePageBean.getBeanList().get("+i+"):"+employeePageBean.getBeanList().get(i));
//        }
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

    public PageBean<Student> findAllStudentsByEmpLevel(int emp_id, int stu_level_id) {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Student> studentPageBean=new PageBean<Student>();
        int totalStudents;
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        //获得所有学生
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        List<Student> studentList=studentMapper.findAllStudentsByEmpLevel(emp_id,stu_level_id);
        totalStudents=studentMapper.countAllStudentsByEmpLevel(emp_id, stu_level_id);

        studentPageBean.setBeanList(studentList);
        studentPageBean.setTotalRecords(totalStudents);

        session.close();
        return studentPageBean;
    }

    @Override
    public PageBean<Employee> adminFindAllEmployees(int currentPage) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        PageBean<Employee> employeePageBean=new PageBean<Employee>();
        int pageSize=EMPLOYEE_PAGE_SIZE;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int totalRecords=employeeMapper.countAllEmployee();

        int from=(currentPage-1)*pageSize;

        List<Employee> employeeList=employeeMapper.adminFindAllEmployees(from,pageSize);

        employeePageBean.setPageSize(pageSize);
        employeePageBean.setCurrentPage(currentPage);
        employeePageBean.setTotalRecords(totalRecords);
        employeePageBean.setTotalPages(employeePageBean.getTotalPages());
        employeePageBean.setBeanList(employeeList);

        return employeePageBean;
    }

    @Override
    public Integer addEmployee(Employee employee) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        Integer empid=null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        try{
            empid=employeeMapper.addEmployee(employee);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return empid;
    }

    @Override
    public void deleteEmployee(int emp_id) {
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
        try{
            employeeMapper.deleteEmployee(emp_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
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
        try{
            employeeMapper.updateEmployee(employee);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
