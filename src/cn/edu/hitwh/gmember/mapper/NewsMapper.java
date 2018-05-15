package cn.edu.hitwh.gmember.mapper;

import cn.edu.hitwh.gmember.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    public Integer addNews(News news);
    public List<News> findNewsBySection(@Param(value = "news_section_id") int news_section_id, @Param(value = "from") int from, @Param(value = "pageSize") int pageSize);
    public Integer countNewsBySection(int news_section_id);
    public Integer countAllNews();
    public List<News> findAllNews(@Param("from") int from,@Param("pageSize")int pageSize);
}
