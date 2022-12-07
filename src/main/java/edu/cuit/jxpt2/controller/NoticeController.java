package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Notice;
import edu.cuit.jxpt2.mapper.NoticeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeMapper noticeMapper;

    public NoticeController(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }
    @GetMapping("/notices")
    public List<Notice> getNotice() {
        try {
            return noticeMapper.getAllNotice();
        } catch (NullPointerException nol) {
            return null;
        }
    }

    @GetMapping
    public ModelAndView noticeView() {
        ModelAndView modelAndView = new ModelAndView("notice");
        return modelAndView;
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
