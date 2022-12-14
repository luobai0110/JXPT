package edu.cuit.jxpt2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller


@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces="text/html;charset=utf-8")

    public class SummitController {
        @RequestMapping(value = "/uploadFile")
        @ResponseBody
        public void upload(String id, MultipartFile uploadfile) throws IOException {
            System.out.println(id);
            System.out.println(uploadfile);
            // 获取上传文件的名称
            String originalFilename =uploadfile.getOriginalFilename();
            uploadfile.transferTo(new File("C:\\upload"+uploadfile));


        }

    }



