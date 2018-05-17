import cn.edu.hitwh.gmember.dao.INewsSectionDao;
import cn.edu.hitwh.gmember.dao.INoticeSectionDao;
import cn.edu.hitwh.gmember.dao.IStulevelDao;
import cn.edu.hitwh.gmember.daoImp.NewsSectionDaoImp;
import cn.edu.hitwh.gmember.daoImp.NoticeSectionDaoImp;
import cn.edu.hitwh.gmember.daoImp.StulevelDaoImp;
import cn.edu.hitwh.gmember.pojo.NewsSection;
import cn.edu.hitwh.gmember.pojo.NoticeSection;
import cn.edu.hitwh.gmember.pojo.StuLevel;
import cn.edu.hitwh.gmember.tools.PageBean;

public class MyNNTest {
    public static void main(String[] args) {
        INoticeSectionDao noticeSectionDao=new NoticeSectionDaoImp();
        INewsSectionDao newsSectionDao=new NewsSectionDaoImp();

        PageBean<NoticeSection>pageBean=noticeSectionDao.findAllNoticeSections();

        for(int i=0;i<pageBean.getBeanList().size();i++){
            System.out.println("通知分类列表："+pageBean.getBeanList().get(i).toString());
        }

        System.out.println("====================================================================");

        PageBean<NewsSection>pageBean2=newsSectionDao.findAllNewsSections();

        for(int i=0;i<pageBean2.getBeanList().size();i++){
            System.out.println("新闻分类列表："+pageBean2.getBeanList().get(i).toString());
        }
    }
}
