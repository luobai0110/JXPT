package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {
    @Select("SELECT * FROM notice")
    List<Notice> getAllNotice();
    @Select("SELECT * FROM notice WHERE id = #{id}")
    Notice getNoticeById(@Param("id") Integer id);
    @Select("SELECT * FROM notice WHERE title LIKE CONCAT('%',#{title},'%')")
    List<Notice> getNoticeByTitle(@Param("title") String title);

    @Insert("INSERT INTO notice (notice, date, mask, title) VALUES (#{notice}, #{date}, #{mask}, #{title})")
    void addNotice(Notice notice);
    @Delete("DELETE FROM notice WHERE id = #{id}")
    void deleteNotice(Integer id);

}
