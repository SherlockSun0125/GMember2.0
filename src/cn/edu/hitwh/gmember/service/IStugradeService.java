package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Stugrade;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IStugradeService {
    public PageBean<Stugrade> findAllStuGrades();
}
