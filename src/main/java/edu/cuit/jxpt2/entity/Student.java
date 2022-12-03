package edu.cuit.jxpt2.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Data
public class Student {
    private long id;
    private Integer class_id;
    private String name;
    private String passwd;

    public void setPasswd(String passwd) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(passwd.getBytes());
            this.passwd = new BigInteger(1,messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
