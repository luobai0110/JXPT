package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Teacher {
    private Integer id;
    private String name;
    private Integer school_id;
}
