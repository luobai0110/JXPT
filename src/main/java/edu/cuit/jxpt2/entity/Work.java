package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Data
public class Work {
    private Integer id;
    private String name;
    private byte[] work;
    private String tags;
    private Integer teacher_id;
}
