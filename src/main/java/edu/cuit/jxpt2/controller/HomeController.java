package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Work;
import edu.cuit.jxpt2.mapper.WorkMapper;
import edu.cuit.jxpt2.servise.GetWork;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final GetWork getWork;

    public HomeController(Work work, GetWork getWork) {
        this.getWork = getWork;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("getFile")
    public String getFile() {
        return "index";
    }

    @PostMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, InterruptedException {
        log.info(String.valueOf(multipartFile));
        getWork.workToDB(multipartFile);
        return "success";
    }
}
