import cn.edu.hitwh.gmember.pojo.Project;
import cn.edu.hitwh.gmember.service.IProjectService;
import cn.edu.hitwh.gmember.serviceImp.ProjectServiceImp;

public class MyProjectTest {
    public static void main(String[] args) {
        IProjectService projectService=new ProjectServiceImp();

//        修改
//        Project project=new Project();
//        project=projectService.findProjectById(9002);
//        project.setProject_about("这是一个大型的java软件");
//        projectService.updateProject(project);


//        查找
//        String detail=projectService.findProjectById(9002).toString();
//        System.out.println("8001号课程的详细信息为："+detail);

//        删除
//        projectService.deleteProject(9003);



//        增加
        Project project=new Project();
        project.setStu_id(1002);
        project.setProject_name("微信小程序");
        project.setProject_place("宋健北520");
        project.setProject_start_time("第八周");
        project.setProject_stop_time("第十八周");
        project.setProject_member("本人");
        project.setStu_level_id(1);
        project.setProject_about("微信小程序，各项功能完好！");


        Integer id=projectService.addProject(project);
        if(id==null) {
            System.out.println("+++++++失败+++++++");
        }else{
            System.out.println("++++++++++++++id=" + id);
        }



//        查找
//        PageBean<Project> projectPageBean=new PageBean<Project>();
//        projectPageBean=projectService.findProjectsByStuId(1002);
//
//        List<Project> projects=projectPageBean.getBeanList();
//
//        for (int i=0;i<projects.size();i++){
//            System.out.println("第"+i+"个课程为："+projects.get(i));
//        }
    }
}
