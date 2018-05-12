package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Employee;

public interface IEmployeeDao {
    public Employee findEmployee(String id,String pwd);
}
