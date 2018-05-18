import cn.edu.hitwh.gmember.mapper.NoticeMapper;
import cn.edu.hitwh.gmember.pojo.Notice;
import cn.edu.hitwh.gmember.service.INoticeService;
import cn.edu.hitwh.gmember.serviceImp.NoticeServiceImp;
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
        INoticeService noticeService=new NoticeServiceImp();

//        Notice notice=noticeService.findNoticeById(6113);
////        notice.setNoti_title("这是用于测试更新的公告");
////
////        noticeService.updateNotice(notice);

        noticeService.deleteNotice(6114);
    }

}
