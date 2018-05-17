import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.NOTICE_PAGE_SIZE;

public class MyTeacherTest {
    public static void main(String[] args) {
        ITeacherDao teacherDao = new TeacherDaoImp();
        Teacher teacher=new Teacher();
        //2009,"2009","孟子","男",39,3,"17862702009","2009@qq.com","2009"

        teacher=teacherDao.findTeacher("2009","2009");

        teacher.setTea_num("2009");
        teacher.setTea_name("李广");
        teacher.setTea_age(45);
        teacher.setTea_sex("男");
        teacher.setDep_id(4);
        teacher.setTea_phone("15037122895");
        teacher.setTea_mail("15037122895@qq.com");
        teacher.setTea_pwd("2009");

        System.out.println(teacher.toString());
        teacherDao.updateTeacher(teacher);

//        Integer teaid=teacherDao.addTeacher(teacher);

//        System.out.println("teaid="+teaid);



//        PageBean<Teacher> teacherPageBean = teacherDao.findAllTeachers();
//        System.out.println("!!!!!!!!!!!!!!!teacherPageBean=" + teacherPageBean.toString());
    }
}
