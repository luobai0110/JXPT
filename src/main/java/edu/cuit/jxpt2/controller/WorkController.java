package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Task;
import edu.cuit.jxpt2.mapper.TaskMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("show files")
public class WorkController {

    private final TaskMapper taskMapper;
    public WorkController(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }
    @GetMapping("getWorkList")
    public ModelAndView getWorkList(ModelAndView modelAndView) {
        List<Task> tasks = taskMapper.getAllWork();
        modelAndView.addObject("works", tasks);
        return modelAndView;
    }

    @GetMapping("getWork")
    public void getWork() {

    }
}
