package edu.cuit.jxpt2.mapper;

import edu.cuit.jxpt2.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("INSERT INTO admin VALUES (name = #{name}, passwd = #{passwd})")
    void addAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE id = #{id}")
    void deleteAdmin(Integer id);

    @Update("UPDATE student SET name = #{name}")
    void updateAdmin(Admin admin);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Admin getAdminById(Integer id);

    @Select("SELECT * FROM student")
    List<Admin> getAllAdmin();

    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Admin> getAdminByName(String name);
}
