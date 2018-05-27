package cn.edu.hitwh.gmember.service;

import cn.edu.hitwh.gmember.pojo.Resume;

public interface IResumeService {
    public Resume findResumeByStuId(int stu_id);
    public Resume findResumeById(int resume_id);
    public Integer addResume(Resume resume);
    public void updateResume(Resume resume);
}
