package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.IClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Insert("INSERT INTO Class (name, majorId, nums, grade) values (#{name}, #{majorId}, #{nums}, #{grade})")
    void addIClass(IClass Class);
    @Delete("DELETE FROM Class WHERE id=#{id}")
    void deleteClass(Integer id);
    @Update("UPDATE Class SET name = #{name}, majorId = #{majorId}, nums = #{nums} WHERE id = #{id}")
    void updateClass(IClass Class);
    @Select("SELECT * FROM Class WHERE id = #{id}")
    Class getClassById(Integer id);
    @Select("SELECT * FROM Class")
    List<Class> getAllClass();
    @Select("SELECT * FROM Class WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Class> getClassByName(String name);
}
