import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.pojo.Notice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static cn.edu.hitwh.gmember.tools.PageConstants.NOTICE_PAGE_SIZE;

public class MyNoticeTest {
    public static void main(String[] args){
        String resource = "MyBatisConfig.xml";
        Reader reader=null;
        SqlSession session;
        try {
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
        NoticeMapper noticeMapper=session.getMapper(NoticeMapper.class);
        int secionid=1;
        int from=0;
        int pageSize=NOTICE_PAGE_SIZE;


        List<Notice> notices=noticeMapper.findNoticesBySection(secionid,from,pageSize);
        for(int i=0;i<notices.size();i++){
            Notice notice=notices.get(i);
            System.out.println("findNoticesBySection"+i+":"+notice.toString());
        }
        System.out.println("=================================================");
        List<Notice> noticess=noticeMapper.findAllNotices(from,pageSize);
        for(int i=0;i<noticess.size();i++){
            Notice notice=noticess.get(i);
            System.out.println("findNoticesBySection"+i+":"+notice.toString());
        }
        System.out.println("=================================================");
        int totalRecords=noticeMapper.countAllNotices();
        int typeRecords1=noticeMapper.countNoticesBySection(1);
        int typeRecords2=noticeMapper.countNoticesBySection(2);
        int typeRecords3=noticeMapper.countNoticesBySection(3);
        System.out.println("=================================================");
        System.out.println("totalRecords为:"+totalRecords);
        System.out.println("=================================================");
        System.out.println("typeRecords1(类型一个数为):"+typeRecords1);
        System.out.println("typeRecords2(类型一个数为):"+typeRecords2);
        System.out.println("typeRecords3(类型一个数为):"+typeRecords3);

        session.close();
    }

}
