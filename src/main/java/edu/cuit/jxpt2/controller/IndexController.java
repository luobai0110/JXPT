package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Course;
import edu.cuit.jxpt2.entity.Task;
import edu.cuit.jxpt2.mapper.CourseMapper;
import edu.cuit.jxpt2.servise.GetTaskFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@RequestMapping("/index")
@Slf4j
@RestController
public class IndexController {

    private final CourseMapper courseMapper;
    public IndexController(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourse();
    }

    @GetMapping("/course/{id}")
    public String getCourse(@PathVariable Integer id) {
        return "forward:course";
    }
}
