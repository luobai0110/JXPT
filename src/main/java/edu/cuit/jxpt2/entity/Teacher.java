package edu.cuit.jxpt2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Human {
    private Integer id;
    private String name;
    private Integer school_id;
    private String passwd;
}
