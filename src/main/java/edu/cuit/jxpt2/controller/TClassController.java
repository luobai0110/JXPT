package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.TClass2;
import edu.cuit.jxpt2.mapper.TClass2Mapper;
import edu.cuit.jxpt2.mapper.TClassMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/t_class")
public class TClassController {
    private final TClassMapper tClassMapper;

    private final TClass2Mapper tClass2Mapper;

    public TClassController(TClassMapper tClassMapper, TClass2Mapper tClass2Mapper) {
        this.tClass2Mapper = tClass2Mapper;
        this.tClassMapper = tClassMapper;
    }

    @GetMapping
    public String getView() {
        return null;
    }
    @GetMapping("/t_classes")
    @ResponseBody
    public List<TClass2> getTClasses(HttpSession session) {
        String identity = (String) session.getAttribute("identity");
        if (identity.equals("admin")) return tClass2Mapper.getAllTClass2();
        else if (identity.equals("teacher")) return tClass2Mapper.getAllTClass2ByTeacherId((Integer) session.getAttribute("userid"));
        else return null;
    }

    @GetMapping("/{id}")
    public TClass2 getTClass2(@PathVariable Integer id) {
        return tClass2Mapper.getTClass2ByTClassId(id);
    }

}
