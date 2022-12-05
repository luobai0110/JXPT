package edu.cuit.jxpt2.entity;

import edu.cuit.jxpt2.interf.People;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Admin implements People {
    private String name;
    private Integer id;
    private String passwd;
}
