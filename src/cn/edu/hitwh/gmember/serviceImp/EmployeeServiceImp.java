package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IEmployeeDao;
import cn.edu.hitwh.gmember.daoImp.EmployeeDaoImp;
import cn.edu.hitwh.gmember.pojo.Employee;
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
}
