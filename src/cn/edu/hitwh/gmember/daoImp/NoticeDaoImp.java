package cn.edu.hitwh.gmember.daoImp;

import cn.edu.hitwh.gmember.dao.INoticeDao;
import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.tools.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.NOTICE_PAGE_SIZE;

public class NoticeDaoImp implements INoticeDao {

    //发布公告
    public Integer addNotice(Notice notice) {
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session=null;
        Integer notiid=null;
        try {
            reader= Resources.getResourceAsReader(resource);

            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            NoticeMapper noticeMapper=session.getMapper(NoticeMapper.class);
            notiid=noticeMapper.addNotice(notice);
            session.commit();
        }catch (IOException e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return notiid;
    }

    //按板块查找notice
    public PageBean<Notice> findNoticesBySection(int sectionid, int currentPage) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        PageBean<Notice> pageBean = new PageBean<Notice>();
        int pageSize=NOTICE_PAGE_SIZE;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        NoticeMapper NoticeMapper = session.getMapper(NoticeMapper.class);

        int totalRecords=NoticeMapper.countNoticesBySection(sectionid);
        int from=(currentPage - 1) * pageSize;// 当前页首行记录的下标
        List<Notice> NoticeList= NoticeMapper.findNoticesBySection(sectionid, from,pageSize);
        pageBean.setBeanList(NoticeList);
        pageBean.setTotalRecods(totalRecords);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        System.out.println("---------------------------------------");
        for(Notice Notice:pageBean.getBeanList()){
            System.out.println("Dao层通过pageBean获得id:"+Notice.getNoti_id());
        }
        System.out.println("---------------------------------------");
        session.close();
        return pageBean;
    }

    //查找所有公告
    public PageBean<Notice> findAllNotices(int currentPage) {
        String resource = "MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session = null;
        PageBean<Notice> pageBean = new PageBean<Notice>();
        int pageSize=NOTICE_PAGE_SIZE;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        NoticeMapper NoticeMapper = session.getMapper(NoticeMapper.class);
        int totalRecords=NoticeMapper.countAllNotices();

        int from=(currentPage - 1) * pageSize;// 当前页首行记录的下标
//        System.out.println("currentpage="+currentPage+";from="+from+";pageSize="+pageSize);
        List<Notice> NoticeList= NoticeMapper.findAllNotices(from,pageSize);
//        将获取的新闻list存入pageBean
        pageBean.setBeanList(NoticeList);
//        将总的新闻数存入pageBean
        pageBean.setTotalRecods(totalRecords);
//        将当前页码存入pageBean
        pageBean.setCurrentPage(currentPage);
//        将页面新闻数存入pageBean
        pageBean.setPageSize(pageSize);

        System.out.println("---------------------------------------");
        for(Notice Notice:pageBean.getBeanList()){
            System.out.println("Dao层通过pageBean获得id:"+Notice.getNoti_id());
        }
        System.out.println("---------------------------------------------");
        session.close();
        return pageBean;
    }
}
