package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.PTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PTaskMapper {
    @Insert("INSERT INTO publish_task (name, description, deadline, mark, teacher_id) VALUES (#{name},#{descrition}, #{date},#{mark},#{teacher_id})")
    void addPTask(PTask pTask);
    @Delete("DELETE FROM publish_task WHERE id = #{id}")
    void deletePTask(Integer id);
    @Update("UPDATE publish_task SET description = #{descritopn}, deadline = #{date}, teacher_id=#{teacher_id},mark = #{mark},name = #{name} ")
    void updatePTask(PTask pTask);
    @Select("SELECT * FROM publish_task WHERE id = #{id}")
    PTask getPTaskById(Integer id);
    @Select("SELECT * FROM publish_task")
    List<PTask> getAllPTask();
    @Select("SELECT * FROM publish_task WHERE name LIKE CONCAT('%',#{name},'%')")
    List<PTask> getPTaskByName(String name);
}
