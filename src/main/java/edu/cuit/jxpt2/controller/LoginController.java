package edu.cuit.jxpt2.controller;


import edu.cuit.jxpt2.entity.Human;
import edu.cuit.jxpt2.mapper.StudentMapper;
import edu.cuit.jxpt2.servise.PassWord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final StudentMapper studentMapper;

    private final PassWord passWord;

    public LoginController(StudentMapper studentMapper, PassWord passWord) {
        this.passWord = passWord;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "passwd") String password) {
        if (passWord.encryptPasswd(password)
                .equals(studentMapper.getStudentById(Integer.valueOf(username))
                        .getPasswd())) {
            return "success";
        } else {
            return "";
        }
    }

    @GetMapping
    public ModelAndView turnToLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }
}
