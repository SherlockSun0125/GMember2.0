import cn.edu.hitwh.gmember.dao.ITeacherDao;
import cn.edu.hitwh.gmember.daoImp.DepartmentDaoImp;
import cn.edu.hitwh.gmember.daoImp.TeacherDaoImp;
import cn.edu.hitwh.gmember.pojo.Department;
import cn.edu.hitwh.gmember.pojo.Teacher;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyDepartmentTest {
    public static void main(String[] args) {
        DepartmentDaoImp departmentDaoImp=new DepartmentDaoImp();
        PageBean<Department> departmentPageBean;
        departmentPageBean=departmentDaoImp.findAllDepartments();

        for(int i=0;i < departmentPageBean.getBeanList().size();i++){
            System.out.println("departmentPageBean.getBeanList().toString():"+departmentPageBean.getBeanList().get(i).toString());
        }

    }
}
