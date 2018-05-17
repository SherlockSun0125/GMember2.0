package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IStulevelService {
    public PageBean<StuLevel> findAllStuLevels();
}
