import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.Comtype;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.service.IComtypeService;
import cn.edu.hitwh.gmember.serviceImp.ComtypeServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyComtypeTest {
    public static void main(String[] args) {
        IComtypeService service=new ComtypeServiceImp();

        PageBean<Comtype> pageBean=service.findAllComtypes();

        for(int i=0;i<pageBean.getBeanList().size();i++){
            System.out.println("公司类型："+pageBean.getBeanList().get(i).toString());
        }
    }
}
