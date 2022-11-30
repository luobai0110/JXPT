package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Insert("INSERT INTO Course (name, major_id) values (#{name}, #{major_id})")
    void addCourse(Course Course);
    @Delete("DELETE FROM Course WHERE id=#{id}")
    void deleteCourse(Integer id);
    @Update("UPDATE Course SET name = #{name}, major_id = #{major_id} WHERE id = #{id}")
    void updateCourse(Course Course);
    @Select("SELECT * FROM Course WHERE id = #{id}")
    Course getCourseById(Integer id);
    @Select("SELECT * FROM Course")
    List<Course> getAllCourse();
    @Select("SELECT * FROM Course WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Course> getCourseByName(String name);
}
