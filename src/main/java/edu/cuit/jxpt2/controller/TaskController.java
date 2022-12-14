package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.PTask;
import edu.cuit.jxpt2.mapper.PTaskMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final PTaskMapper pTaskMapper;

    public TaskController(PTaskMapper pTaskMapper) {
        this.pTaskMapper = pTaskMapper;
    }
    @GetMapping("/new")
    public String publishNewTask() {
        return "newTask";
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<PTask> getTasks(HttpSession session) {
        if(session.getAttribute("userid") == null) return null;
        Integer id = (Integer) session.getAttribute("userid");
        return pTaskMapper.getTaskByTeacherId(id);
    }

    @PostMapping("/new")
    @ResponseBody
    public ModelAndView addTask(@RequestParam(value = "deadline") String deadline) throws ParseException {
        deadline=deadline.replace("T","\s");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.parse(deadline));
        return new ModelAndView("/teacher");
    }

    @GetMapping
    public String getView() {
        return null;
    }
}
