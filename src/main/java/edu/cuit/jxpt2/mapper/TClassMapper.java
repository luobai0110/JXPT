package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.T_class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TClassMapper {
    @Insert("INSERT INTO T_class (name, teacher_id, course_id) values (#{name}, #{teacher_id}, #{course_id})")
    void addIT_class(T_class T_class);
    @Delete("DELETE FROM T_class WHERE id=#{id}")
    void deleteT_class(Integer id);
    @Update("UPDATE T_class SET name = #{name},teacher_id = #{teacher_id}, course_id = #{course_id} WHERE id = #{id}")
    void updateT_class(T_class T_class);
    @Select("SELECT * FROM T_class WHERE id = #{id}")
    T_class getT_classById(Integer id);
    @Select("SELECT * FROM T_class")
    List<T_class> getAllT_class();
    @Select("SELECT * FROM T_class WHERE name LIKE CONCAT('%',#{name},'%')")
    List<T_class> getT_classByName(String name);
}
