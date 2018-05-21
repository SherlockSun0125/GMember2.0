import cn.edu.hitwh.gmember.dao.IStulogDao;
import cn.edu.hitwh.gmember.daoImp.StulogDaoImp;
import cn.edu.hitwh.gmember.pojo.StuLog;
import cn.edu.hitwh.gmember.service.IStulogService;
import cn.edu.hitwh.gmember.serviceImp.StulogServiceImp;
import cn.edu.hitwh.gmember.tools.PageBean;

import java.util.List;

public class MyStulogTest {
    public static void main(String[] args) {
        IStulogService stulogService=new StulogServiceImp();
        IStulogDao stulogDao=new StulogDaoImp();

//        测试更新
//        StuLog stulog=stulogService.findLogByid(7001);
//        System.out.println("更改前："+stulog.toString());
//
//        stulog.setTea_feedback("改进之后很棒");
//        stulog.setTea_status(3);
//        stulogService.updateStuLog(stulog);
//        stulog=stulogService.findLogByid(7001);
//        System.out.println("更改后："+stulog.toString());


//        测试删除
//        stulogService.deleteStuLog(7077);

//        增加操作
//        StuLog stuLog=stulogService.findLogByid(7001);
//        int id=stulogService.addStuLog(stuLog);
//        System.out.println("id为："+id);


        PageBean<StuLog> stuLogPageBean=stulogService.findLogsOfTeacherLevel(2001,1,1);

        List<StuLog> stuLogList=stuLogPageBean.getBeanList();
        for(int i=0;i<stuLogList.size();i++){
            System.out.println("第"+i+"为"+stuLogList.get(i));
        }


        PageBean<StuLog> stuLogPageBean1=stulogService.findLogsOfTeacherLevel(2001,1,2);

        List<StuLog> stuLogList1=stuLogPageBean1.getBeanList();
        for(int i=0;i<stuLogList1.size();i++){
            System.out.println("第"+i+"为"+stuLogList1.get(i));
        }

        PageBean<StuLog> stuLogPageBean2=stulogService.findLogsOfTeacherLevel(2001,1,3);

        for(int i=0;i<stuLogPageBean2.getBeanList().size();i++){
            System.out.println("第"+i+"为"+stuLogPageBean2.getBeanList().get(i));
        }

        PageBean<StuLog> stuLogPageBean3=stulogService.findLogsOfTeacherLevel(2001,1,4);

        List<StuLog> stuLogList3=stuLogPageBean1.getBeanList();
        for(int i=0;i<stuLogList1.size();i++){
            System.out.println("第"+i+"为"+stuLogList3.get(i));
        }

        PageBean<StuLog> stuLogPageBean4=stulogService.findLogsOfTeacherLevel(2001,1,5);

        for(int i=0;i<stuLogPageBean4.getBeanList().size();i++){
            System.out.println("第"+i+"为"+stuLogPageBean4.getBeanList().get(i));
        }

        PageBean<StuLog> stuLogPageBean5=stulogService.findLogsOfTeacherLevel(2001,1,6);

        for(int i=0;i<stuLogPageBean5.getBeanList().size();i++){
            System.out.println("第"+i+"为"+stuLogPageBean5.getBeanList().get(i));
        }
    }
}
