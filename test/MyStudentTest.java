import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.IStudentService;
import cn.edu.hitwh.gmember.service.IStulevelService;
import cn.edu.hitwh.gmember.serviceImp.StudentServiceImp;
import cn.edu.hitwh.gmember.serviceImp.StulevelServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyStudentTest {
    public static void main(String[] args) {
        IStudentDao studentDao=new StudentDaoImp();
        PageBean<Student> studentPageBean=new PageBean<Student>();

//        studentPageBean=studentDao.findStudentsByLevel(3);

        System.out.println("共有学生为："+studentDao.countAllStudents());
//
//        studentPageBean=studentDao.findStudentsByLevel(0);

        IStudentService studentService=new StudentServiceImp();


        Student student=studentService.findStudentById(1026);
        student.setStu_english("四级满分");
        student.setStu_major("网络安全");
        student.setStu_note("hahahahahaha");
//        studentService.updateStudent(student);
        student.setStu_id(1028);
//        student.setTea_id(null);

        studentService.addStudent(student);
//        student.setStu_num("140410429");
//        student.setStu_id(1027);
//        studentService.addStudent(student);

//        System.out.println(studentService.findStudentById(1010));

//        studentPageBean=studentService.findStudentsByLevel(0);
//
//        for(int i=0;i<studentPageBean.getBeanList().size();i++)
//            System.out.println("学生列表元素："+studentPageBean.getBeanList().get(i).toString());

//        Student student=new Student(1017,"140410417","孙辉","1017","男",22,3003,8,"1017","1017@163.com",4,"");

//        studentDao.addStudent(student);
//        System.out.println("共有学生为："+studentDao.countAllStudents());

//        studentDao.deleteStudent(1019);
//        System.out.println("共有学生为："+studentDao.countAllStudents());

//        studentDao.updateStudent(student);


    }
}
