package edu.cuit.jxpt2.interf;

import org.springframework.stereotype.Component;

@Component
public interface People {
    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getPasswd();

    void setPasswd(String passwd);
}
