package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class T_class {
    private Integer id;
    private Integer teacher_id;
    private Integer course_id;
}
