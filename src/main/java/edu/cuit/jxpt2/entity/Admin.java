package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Admin {
    private String name;
    private Integer id;
}
