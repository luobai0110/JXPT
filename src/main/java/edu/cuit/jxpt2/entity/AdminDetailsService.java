package edu.cuit.jxpt2.entity;

import edu.cuit.jxpt2.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService {
    private AdminMapper adminMapper;

    public AdminDetailsService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminMapper.getAdminById(Integer.valueOf(username));

    }
}
