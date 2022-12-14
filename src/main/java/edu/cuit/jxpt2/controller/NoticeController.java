package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Notice;
import edu.cuit.jxpt2.mapper.NoticeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeMapper noticeMapper;

    public NoticeController(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }
    @GetMapping("/notices")
    @ResponseBody
    public List<Notice> getNotice() {
        try {
            return noticeMapper.getAllNotice();
        } catch (NullPointerException nol) {
            return null;
        }
    }

    @GetMapping
    public String getView() {
        return "notices";
    }

    @GetMapping("{id}")
    public Notice getNotice(@PathVariable Integer id) {
        try {
            return noticeMapper.getNoticeById(id);
        } catch (NullPointerException nullPointerException) {
            return null;
        }
    }
}
