package edu.cuit.jxpt2.entity;

import edu.cuit.jxpt2.interf.People;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Teacher implements People {
    private Integer id;
    private String name;
    private Integer school_id;
    private String passwd;
}
