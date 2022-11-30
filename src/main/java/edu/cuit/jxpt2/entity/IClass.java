package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class IClass {
    private Integer id;
    private Integer major_id;
    private Integer nums;
    private Integer t_id;
}
