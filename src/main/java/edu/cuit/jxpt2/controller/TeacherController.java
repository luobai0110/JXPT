package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Teacher;
import edu.cuit.jxpt2.mapper.TeacherMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherMapper teacherMapper;

    public TeacherController(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }
    @GetMapping("/info")
    public ModelAndView getInfo(@RequestParam HttpSession session) {
        Integer id = (Integer) session.getAttribute("userid");
        Teacher teacher = teacherMapper.getTeacherById(id);
        return new ModelAndView("info","teacher",teacher);
    }

    @GetMapping
    public String getView() {
        return "teacher";
    }
}
