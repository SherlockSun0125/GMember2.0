package cn.edu.hitwh.gmember.dao;

import cn.edu.hitwh.gmember.pojo.Resume;

public interface IResumeDao {
    public Resume findResumeByStuId(int stu_id);
    public Resume findResumeById(int resume_id);
    public Integer addResume(Resume resume);
    public void updateResume(Resume resume);

}
