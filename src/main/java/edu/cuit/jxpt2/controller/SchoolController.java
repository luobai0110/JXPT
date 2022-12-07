package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.School;
import edu.cuit.jxpt2.mapper.SchoolMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private SchoolMapper schoolMapper;
    public SchoolController(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }
    @GetMapping
    public List<School> getSchools() {
        return schoolMapper.getAllSchool();
    }
}
