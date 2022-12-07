package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class T_Class {
    private Integer id;
    private Integer teacher_id;
    private Integer course_id;
    private Integer class_id;
    private String course_name;
    private String teacher_name;
}
