package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Course;
import edu.cuit.jxpt2.mapper.MajorMapper;
import edu.cuit.jxpt2.servise.dao.CourseDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseDAO courseDao;

    private final MajorMapper majorMapper;


    public CourseController(CourseDAO courseDao, MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
        this.courseDao = courseDao;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseDao.getAllCCourses();
    }

    @GetMapping("/{id}")
    public ModelAndView getCourse(@PathVariable Integer id, ModelAndView modelAndView) {
        Course course = courseDao.getCourseById(id);
        modelAndView.setViewName("course");
        modelAndView.addObject("majorName", majorMapper.getMajorById(course.getMajorId()).getName());
        modelAndView.addObject("courseName", course.getName());
        modelAndView.addObject("courseId",course.getId());
        return modelAndView;
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

    @PostMapping("/add")
    public ModelAndView addCourse(Course course) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        courseDao.addCourse(course);
        return modelAndView;
    }

    @PutMapping("/update")
    public void updateCourse(HttpServletRequest request) {

    }
}
