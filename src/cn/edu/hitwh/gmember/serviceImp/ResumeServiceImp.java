package cn.edu.hitwh.gmember.serviceImp;

import cn.edu.hitwh.gmember.dao.IResumeDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.ResumeDaoImp;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.Resume;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.service.IResumeService;
import cn.edu.hitwh.gmember.service.IStulevelService;
import cn.edu.hitwh.gmember.tools.PageBean;

public class ResumeServiceImp implements IResumeService {
    IResumeDao resumeDao=new ResumeDaoImp();


    @Override
    public Resume findResumeByStuId(int stu_id) {
        try{
            return resumeDao.findResumeByStuId(stu_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resume findResumeById(int resume_id) {
        try{
            return resumeDao.findResumeById(resume_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer addResume(Resume resume) {
        try{
            return resumeDao.addResume(resume);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateResume(Resume resume) {
        try{
            resumeDao.updateResume(resume);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
