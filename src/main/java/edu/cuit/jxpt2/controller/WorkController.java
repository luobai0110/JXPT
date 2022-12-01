package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Work;
import edu.cuit.jxpt2.mapper.WorkMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("show files")
public class WorkController {

    private final WorkMapper workMapper;
    public WorkController(WorkMapper workMapper){
        this.workMapper = workMapper;
    }
    @GetMapping("getWorkList")
    public ModelAndView getWorkList(ModelAndView modelAndView) {
        List<Work> works = workMapper.getAllWork();
        modelAndView.addObject("works", works);
        return modelAndView;
    }

    @GetMapping("getWork")
    public void getWork() {

    }
}
