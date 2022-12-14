package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
public class PTask {
    private String description;
    private Date deadline;
    private String name;
    private Integer id;
    private Boolean mark;
    private Integer teacherId;
    private Integer tClassId;

    public void setMask(String mask) {
        this.mark = Boolean.parseBoolean(mask);

    }
}
