package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IComtypeService {
    public PageBean<Comtype> findAllComtypes();
}
