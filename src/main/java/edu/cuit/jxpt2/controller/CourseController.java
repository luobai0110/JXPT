package edu.cuit.jxpt2.controller;

import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import edu.cuit.jxpt2.entity.Course;
import edu.cuit.jxpt2.servise.CourseDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseDAO courseDao;

    public CourseController(CourseDAO courseDao) {
        this.courseDao = courseDao;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseDao.getAllCCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseDao.getCourseById(id);
    }

    @DeleteMapping("{id}")
    public ModelAndView deleteCourse(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("courses");
        try {
            courseDao.deleteCourseById(id);
            modelAndView.setStatus(HttpStatus.valueOf(200));
            return modelAndView;
        } catch (NullPointerException nullPointerException) {
            modelAndView.setStatus(HttpStatus.FORBIDDEN);
            return modelAndView;
        }
    }

    @DeleteMapping("/courses")
    public ModelAndView deleteAllCourse(ModelAndView modelAndView) {
        try {
            courseDao.deleteAllCourse();
            modelAndView.setStatus(HttpStatus.OK);
            return modelAndView;
        } catch (NullPointerException nullPointerException) {
            modelAndView.setStatus(HttpStatus.FORBIDDEN);
            return modelAndView;
        }
    }

    @PostMapping()
    public ModelAndView addCourse(Course course) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        courseDao.addCourse(course);
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }
}
