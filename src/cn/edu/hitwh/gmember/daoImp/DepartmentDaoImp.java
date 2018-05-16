package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.IDepartmentDao;
import cn.edu.hitwh.gmember.mapper.DepartmentMapper;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class DepartmentDaoImp implements IDepartmentDao{

    @Override
    public PageBean<Department> findAllDepartments() {
        String resource="MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        PageBean<Department> departmentPageBean=new PageBean<Department>();
        try{
            reader=Resources.getResourceAsReader(resource);
        }catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session=sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper=session.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.findAllDepartments();
//        for(int i=0;i<departmentList.size();i++){
//            System.out.println("======"+departmentList.get(i).toString());
//        }
        departmentPageBean.setBeanList(departmentList);
        return departmentPageBean;
    }
}
