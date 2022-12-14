package edu.cuit.jxpt2.entity;

import edu.cuit.jxpt2.interf.People;
import edu.cuit.jxpt2.mapper.StudentMapper;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class Student implements People {
    private Integer id;
    private Integer classId;
    private String name;
    private String passwd;

}
