package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Task {
    private Integer id;
    private String name;
    private byte[] work;
    private String tags;
    private Integer teacherId;
    private Integer publishTaskId;
}
