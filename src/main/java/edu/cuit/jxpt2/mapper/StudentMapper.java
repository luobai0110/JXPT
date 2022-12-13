package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO student (id, classId, name, passwd) values (#{id},#{classId}, #{name}, #{passwd})")
    void addStudent(Student student);
    @Delete("DELETE FROM student WHERE id=#{id}")
    void deleteStudent(Integer id);
    @Update("UPDATE student SET id = #{id}, classId  = #{classId}, name = #{name}, passwd = #{passwd} WHERE id = #{id}")
    void updateStudent(Student student);
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStudentById(Integer id);
    @Select("SELECT * FROM student")
    List<Student> getAllStudent();
    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Student> getStudentByName(String name);
}
