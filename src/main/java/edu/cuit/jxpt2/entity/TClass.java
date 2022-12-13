package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TClass {
    private Integer id;
    private Integer teacherId;
    private String name;
    private Integer courseId;
    private Integer classId;
}
