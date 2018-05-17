import cn.edu.hitwh.gmember.dao.IStudentDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.StudentDaoImp;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.pojo.Student;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyStulevelTest {
    public static void main(String[] args) {
        IStulevelDao stulevelDao=new StulevelDaoImp();

        PageBean<StuLevel>pageBean=stulevelDao.findAllStuLevels();

        for(int i=0;i<pageBean.getBeanList().size();i++){
            System.out.println("阶段列表："+pageBean.getBeanList().get(i).toString());
        }
    }
}
