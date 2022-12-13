package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Major;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MajorMapper {
    @Insert("INSERT INTO Major (name, schoolId) values (#{name}, #{schoolId})")
    void addMajor(Major Major);
    @Delete("DELETE FROM Major WHERE id=#{id}")
    void deleteMajor(Integer id);
    @Update("UPDATE Major SET name = #{name}, schoolId = #{schoolId} WHERE id = #{id}")
    void updateMajor(Major Major);
    @Select("SELECT * FROM Major WHERE id = #{id}")
    Major getMajorById(Integer id);
    @Select("SELECT * FROM Major")
    List<Major> getAllMajor();
    @Select("SELECT * FROM Major WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Major> getMajorByName(String name);
}
