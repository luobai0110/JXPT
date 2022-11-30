package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO teacher (name, school_id) values (#{name},#{schoold_id})")
    void addTeacher();
    @Delete("DELETE FROM teacher WHERE id = #{id}")
    void deleteTeacher(Integer id);
    @Update("UPDATE teacher SET name = #{name}, school_id = #{school_id}")
    void updateTeacher();
    @Select("SELECT * FROM teacher WHERE id = #{id}")
    Teacher getTeacherById(Integer id);
    @Select("SELECT * FROM teacher")
    List<Teacher> getAllTeacher();
    @Select("SELECT * FROM teacher WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Teacher> getTeacherByName();
}
