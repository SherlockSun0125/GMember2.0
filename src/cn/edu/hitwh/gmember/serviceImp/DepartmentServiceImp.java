package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IDepartmentDao;
import cn.edu.hitwh.gmember.daoImp.DepartmentDaoImp;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.service.IDepartmentService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class DepartmentServiceImp implements IDepartmentService {
    IDepartmentDao departmentDao=new DepartmentDaoImp();


    @Override
    public PageBean<Department> findAllDepartments() {
        try {
            return departmentDao.findAllDepartments();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
