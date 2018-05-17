import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyStudentTest {
    public static void main(String[] args) {
        IStudentDao studentDao=new StudentDaoImp();
        PageBean<Student> studentPageBean=new PageBean<Student>();

//        studentPageBean=studentDao.findStudentsByLevel(3);

        System.out.println("共有学生为："+studentDao.countAllStudents());
//
//        studentPageBean=studentDao.findAllStudents();
//
//        for(int i=0;i<studentPageBean.getBeanList().size();i++)
//            System.out.println("学生列表元素："+studentPageBean.getBeanList().get(i).toString());

        Student student=new Student(1017,"140410417","孙辉","1017","男",22,3003,8,"1017","1017@163.com",4,"");

//        studentDao.addStudent(student);
//        System.out.println("共有学生为："+studentDao.countAllStudents());

//        studentDao.deleteStudent(1019);
//        System.out.println("共有学生为："+studentDao.countAllStudents());

        studentDao.updateStudent(student);


    }
}
