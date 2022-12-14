package edu.cuit.jxpt2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @GetMapping("/new")
    public String publishNewTask() {
        return "#";
    }
}
