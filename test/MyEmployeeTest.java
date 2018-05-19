import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.service.IEmployeeService;
import cn.edu.hitwh.gmember.serviceImp.EmployeeServiceImp;

public class MyEmployeeTest {
    public static void main(String[] args) {
        IEmployeeService service=new EmployeeServiceImp();
        service.findAllEmployeeDetail();
    }
}
