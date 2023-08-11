package com.abuzobaer_comp303_assignment2.security;

import com.abuzobaer_comp303_assignment2.dao.StudentRepository;
import com.abuzobaer_comp303_assignment2.entity.Student;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private StudentRepository userRepository;
    public UserPrincipalDetailsService(StudentRepository repository){
        this.userRepository=repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user=userRepository.findByUsername(username);
        UserPrincipal userPrincipal=new UserPrincipal(user);

        return userPrincipal;
    }
}
