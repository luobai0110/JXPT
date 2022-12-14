package edu.cuit.jxpt2.servise.dao;

import edu.cuit.jxpt2.entity.Course;
import edu.cuit.jxpt2.mapper.CourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseDAO {
    private final CourseMapper courseMapper;

    public CourseDAO(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<Course> getAllCCourses() {
        return courseMapper.getAllCourse();
    }

    public Course getCourseById(Integer id) {
        return courseMapper.getCourseById(id);
    }

    public List<Course> getCourseByName(String name) {
        return courseMapper.getCourseByName(name);
    }

    public void deleteCourseById(Integer id) {
        courseMapper.deleteCourse(id);
    }

    public void deleteAllCourse() {
        List<Course> courses = this.getAllCCourses();
        for (Course course: courses) {
            this.deleteCourseById(course.getId());
        }
    }

    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }
}
