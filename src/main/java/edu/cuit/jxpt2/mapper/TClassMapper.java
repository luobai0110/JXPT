package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.TClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TClassMapper {
    @Insert("INSERT INTO tClass (name, teacherId, courseId,classId) values (#{name}, #{teacherId}, #{courseId}, #{classId})")
    void addTClass(TClass tClass);
    @Delete("DELETE FROM TClass WHERE id=#{id}")
    void deleteTClass(Integer id);
    @Update("UPDATE TClass SET name = #{name},teacherId = #{teacherId}, courseId = #{courseId} ,classId = #{classId} WHERE id = #{id}")
    void updateTClass(TClass tClass);
    @Select("SELECT * FROM tclass WHERE id = #{id}")
    TClass getTClassById(Integer id);
    @Select("SELECT * FROM tclass")
    List<TClass> getAllTClass();
    @Select("SELECT * FROM tclass WHERE tclass.name LIKE CONCAT('%',#{name},'%')")
    List<TClass> getTClassByName(String name);
    @Select("SELECT * FROM tclass WHERE teacherId = #{id}")
    public List<TClass> getTClassByTeacherId(Integer id);
    @Select("SELECT * FROM tclass WHERE courseId = #{id}")
    public List<TClass> getTClassByCourseId(Integer id);

}
