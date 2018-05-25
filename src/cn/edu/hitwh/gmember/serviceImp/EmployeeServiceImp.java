package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IEmployeeDao;
import cn.edu.hitwh.gmember.daoImp.EmployeeDaoImp;
import cn.edu.hitwh.gmember.pojo.Employee;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.service.IEmployeeService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class EmployeeServiceImp implements IEmployeeService {
    IEmployeeDao employeeDao=new EmployeeDaoImp();
    @Override
    public Employee login(Employee employee) {
        try{
           return employeeDao.findEmployee(employee.getEmp_id(),employee.getEmp_pwd());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Employee> findAllEmployeeDetail() {
        try{
            return employeeDao.findAllEmployeeDetail();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findAllEmployeeById(int emp_id) {
        try{
            return employeeDao.findAllEmployeeById(emp_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<Student> findAllStudentsByEmpLevel(int emp_id, int stu_level_id) {
        try{
            return employeeDao.findAllStudentsByEmpLevel(emp_id, stu_level_id);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
