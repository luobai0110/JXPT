package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Insert("INSERT INTO School (id, name) values (#{id}, #{name})")
    void addSchool(School School);
    @Delete("DELETE FROM School WHERE id=#{id}")
    void deleteSchool(Integer id);
    @Update("UPDATE School SET id = #{id}, name = #{name} WHERE id = #{id}")
    void updateSchool(School School);
    @Select("SELECT * FROM School WHERE id = #{id}")
    School getSchoolById(Integer id);
    @Select("SELECT * FROM School")
    List<School> getAllSchool();
    @Select("SELECT * FROM School WHERE name LIKE CONCAT('%',#{name},'%')")
    List<School> getSchoolByName(String name);
}
