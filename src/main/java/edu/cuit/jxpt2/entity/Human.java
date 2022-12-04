package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Human {
    private Integer id;
    private String passwd;
    private String name;
}