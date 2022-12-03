package edu.cuit.jxpt2;

import edu.cuit.jxpt2.entity.Student;
import edu.cuit.jxpt2.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
class Jxpt2ApplicationTests {
    @Autowired
    public StudentMapper studentMapper;
    @Autowired
    public Student student;
    @Test
    void contextLoads() {
        List<Student> students = studentMapper.getAllStudent();
        for (Student s: students) {
            System.out.println(s.toString());
        }
    }

}
