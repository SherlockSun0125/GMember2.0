package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.tools.PageBean;

public interface IStulevelDao {
    public PageBean<StuLevel> findAllStuLevels();

}
