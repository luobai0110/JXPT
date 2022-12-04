package edu.cuit.jxpt2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Human {
    private Integer id;
    private Integer class_id;
    private String name;
    private String passwd;
}
