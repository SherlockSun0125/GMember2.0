package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IDepartmentService {
    public PageBean<Department> findAllDepartments();
}
