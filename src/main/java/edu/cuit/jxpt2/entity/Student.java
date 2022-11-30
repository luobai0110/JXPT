package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    private long id;
    private Integer class_id;
    private String name;
}
