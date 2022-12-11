package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.School;
import edu.cuit.jxpt2.mapper.SchoolMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {

    private final SchoolMapper schoolMapper;
    public SchoolController(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }
    @GetMapping("/schools")
    @ResponseBody
    public List<School> getSchools() {
        return schoolMapper.getAllSchool();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public School getSchool(@PathVariable Integer id) {
        try {
            return schoolMapper.getSchoolById(id);
        } catch (NullPointerException nullPointerException ) {
            return null;
        }
    }

    @GetMapping("/add")
    public String addSchool() {
        return "addSchool";
    }
}
