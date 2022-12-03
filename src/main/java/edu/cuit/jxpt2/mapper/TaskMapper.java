package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO task ( work, name, tags,teach_id, pid) values (#{work}, #{name}, #{tags}, #{teacher_id}, #{publish_task_id})")
    void addWork(Task task);
    @Delete("DELETE FROM task WHERE id=#{id}")
    void deleteWork(Integer id);
    @Update("UPDATE task SET work = #{work}, teach_id = #{teacher_id}, tags = #{tags}, name = #{name}")
    void updateWork(Task Task);
    @Select("SELECT * FROM task WHERE id = #{id}")
    Task getWorkById(Integer id);
    @Select("SELECT * FROM task")
    List<Task> getAllWork();
    @Select("SELECT * FROM task WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Task> getWorkByName(String name);
}
