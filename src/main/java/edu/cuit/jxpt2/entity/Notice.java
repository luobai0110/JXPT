package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Notice {

    private Integer id;
    private String notice;
    private Date date;
    private String mask;

    private String title;
}
