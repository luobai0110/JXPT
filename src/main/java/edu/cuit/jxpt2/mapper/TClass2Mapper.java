package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.TClass2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TClass2Mapper {
    @Select("SELECT * FROM courseview WHERE teacherId = #{teacherId}")
    List<TClass2> getAllTClass2ByTeacherId(Integer teacherId);
    @Select("SELECT * FROM courseview WHERE courseId = #{courseId}")
    List<TClass2> getTClass2ByCourseId(Integer id);
    @Select("SELECT * FROM courseview WHERE courseName LIKE CONCAT('%',#{courseName},'%')")
    List<TClass2> getTClass2ByCourseName(String courseName);
    @Select("SELECT * FROM courseview")
    List<TClass2> getAllTClass2();
    @Select("SELECT * FROM courseview WHERE tClassId = #{tClassId}")
    public TClass2 getTClass2ByTClassId(Integer tClassId);
}
