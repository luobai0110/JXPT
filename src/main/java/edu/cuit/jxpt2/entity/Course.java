package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Course {
    private Integer id;
    private String name;
    private Integer major_id;
}
