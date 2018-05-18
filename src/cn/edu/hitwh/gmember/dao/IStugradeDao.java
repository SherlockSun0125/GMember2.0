package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Stugrade;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IStugradeDao {
    public PageBean<Stugrade> findAllStuGrades();

}
