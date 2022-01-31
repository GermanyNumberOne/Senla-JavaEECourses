package com.senla.courses.project.services.impl;

import com.senla.courses.project.dao.api.UserDao;
import com.senla.courses.project.model.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.senla.courses.project.model.User user = userDao.getUserByLogin(login);

        if(user == null) {
            throw new UsernameNotFoundException("User " + login + " not found");
        }

        return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthorities(user.getRoles()))
                .build();
    }

    public List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
    }

}
