package edu.cuit.jxpt2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Data
@Component
@EqualsAndHashCode(callSuper = true)
public class Admin extends Human {
    private String name;
    private Integer id;
    private String passwd;
}
