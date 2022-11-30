package edu.cuit.jxpt2;

import edu.cuit.jxpt2.entity.Student;
import edu.cuit.jxpt2.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Jxpt2ApplicationTests {
    @Autowired
    public StudentMapper studentMapper;
    @Autowired
    public Student student;
    @Test
    void contextLoads() {
        student = studentMapper.getStudentById(1000);
        System.out.println(student.getName());
    }

}
