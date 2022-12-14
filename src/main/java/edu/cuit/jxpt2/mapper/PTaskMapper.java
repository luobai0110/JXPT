package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.PTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PTaskMapper {
    @Insert("INSERT INTO publishTask (name, description, deadline, mark, teacherId) VALUES (#{name},#{descrition}, #{date},#{mark},#{teacherId})")
    void addPTask(PTask pTask);
    @Delete("DELETE FROM publishTask WHERE id = #{id}")
    void deletePTask(Integer id);
    @Update("UPDATE publishTask SET description = #{descritopn}, deadline = #{date}, teacherId=#{teacherId},mark = #{mark},name = #{name} ")
    void updatePTask(PTask pTask);
    @Select("SELECT * FROM publishTask WHERE id = #{id}")
    PTask getPTaskById(Integer id);
    @Select("SELECT * FROM publishTask")
    List<PTask> getAllPTask();
    @Select("SELECT * FROM publishTask WHERE name LIKE CONCAT('%',#{name},'%')")
    List<PTask> getPTaskByName(String name);
}
