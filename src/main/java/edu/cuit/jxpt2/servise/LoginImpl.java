package edu.cuit.jxpt2.servise;

import edu.cuit.jxpt2.interf.People;
import edu.cuit.jxpt2.mapper.AdminMapper;
import edu.cuit.jxpt2.mapper.StudentMapper;
import edu.cuit.jxpt2.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl {
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final AdminMapper adminMapper;
    private final PassWord passWord;
    private People people;

    public LoginImpl(StudentMapper studentMapper, TeacherMapper teacherMapper,
                     PassWord passWord,
                     AdminMapper adminMapper,
                     People people) {
        this.studentMapper = studentMapper;
        this.teacherMapper = teacherMapper;
        this.passWord = passWord;
        this.adminMapper = adminMapper;
        this.people = people;
    }

    public People login(Integer userid, String passwd, String identity) {
        if (identity.equals("teacher")) {
            people = teacherMapper.getTeacherById(userid);
            return people;
        } else if (identity.equals("student")) {
            people = studentMapper.getStudentById(userid);
            return people;
        } else {
            return null;
        }
    }


    public People adminLogin(Integer userid, String passwd) {
        people = adminMapper.getAdminById(userid);
        if (passWord.encryptPasswd(passwd).equals(passwd)) {
            return people;
        }

        return null;
    }

}
