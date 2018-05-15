package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    public Integer addNotice(Notice notice);
    public List<Notice> findNoticesBySection(@Param(value = "noti_section_id") int noti_section_id, @Param(value = "from") int from, @Param(value = "pageSize") int pageSize);
    public Integer countNoticesBySection(int notice_section_id);
    public Integer countAllNotices();
    public List<Notice> findAllNotices(@Param("from") int from,@Param("pageSize")int pageSize);
}
