package edu.cuit.jxpt2.entity;

import edu.cuit.jxpt2.interf.People;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class Student implements People {
    private Integer id;
    private Integer class_id;
    private String name;
    private String passwd;
}
