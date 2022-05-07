package com.example.securityWithHibernate.Repository;

import com.example.securityWithHibernate.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Lazy
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByUserName(username).get();
        System.out.println(user.getName());
        List<GrantedAuthority> authorities = user.getRoles().stream().
                                                             map(authority -> new SimpleGrantedAuthority(authority.getRole())).
                                                             collect(Collectors.toList());
        return buildUser(user,authorities);

    }

    private UserDetails buildUser(Users user,  List<GrantedAuthority> authorities){
        return new User(user.getName(),user.getUserPassword(),true,true,true,true,authorities);
    }
}
