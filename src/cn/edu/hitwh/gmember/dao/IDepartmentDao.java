package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IDepartmentDao {
    public PageBean<Department> findAllDepartments();

}
