package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkMapper {
    @Insert("INSERT INTO Work ( work, name, tags,teach_id) values (#{work}, #{name}, #{tags}, #{teacher_id})")
    void addWork(Work work);
    @Delete("DELETE FROM Work WHERE id=#{id}")
    void deleteWork(Integer id);
    @Update("UPDATE work SET work = #{work}, teach_id = #{teacher_id}, tags = #{tags}, name = #{name}")
    void updateWork(Work Work);
    @Select("SELECT * FROM Work WHERE id = #{id}")
    Work getWorkById(Integer id);
    @Select("SELECT * FROM Work")
    List<Work> getAllWork();
    @Select("SELECT * FROM Work WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Work> getWorkByName(String name);
}
