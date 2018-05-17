package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IComtypeDao {
    public PageBean<Comtype> findAllComtypes();

}
