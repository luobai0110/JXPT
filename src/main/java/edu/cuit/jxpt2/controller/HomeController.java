package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Task;
import edu.cuit.jxpt2.servise.GetTaskFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping("/")
@Slf4j
public class HomeController {

    private final GetTaskFile getTaskFile;

    public HomeController(Task task, GetTaskFile getTaskFile) {
        this.getTaskFile = getTaskFile;
    }



    @GetMapping("getFile")
    public String getFile() {
        return "index";
    }

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, InterruptedException {
        log.info(String.valueOf(multipartFile));
        getTaskFile.workToDB(multipartFile);
        return "success";
    }
}
