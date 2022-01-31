package com.senla.courses.project.controllers;

import com.senla.courses.project.dto.BankAccountDto;
import com.senla.courses.project.dto.UserDto;
import com.senla.courses.project.services.api.BankAccountService;
import com.senla.courses.project.services.api.UserService;
import com.senla.courses.project.dto.AuthenticationDto;
import com.senla.courses.project.dto.RoleDto;
import com.senla.courses.project.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/auth")
@RestController
@Slf4j
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody AuthenticationDto dto) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        UserDto userDto = new UserDto();
        userDto.setLogin(dto.getLogin());
        userDto.setRoles(new ArrayList<>());
        RoleDto role = new RoleDto();
        role.setId(2l);
        userDto.getRoles().add(role);
        userDto.setPassword(dto.getPassword());
        bankAccountDto.setUser(userDto);

        bankAccountService.create(bankAccountDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/admin/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerAdmin(@RequestBody AuthenticationDto dto) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        UserDto userDto = new UserDto();
        userDto.setLogin(dto.getLogin());
        userDto.setRoles(new ArrayList<>());
        RoleDto role = new RoleDto();
        role.setId(1l);
        userDto.getRoles().add(role);
        userDto.setPassword(dto.getPassword());
        bankAccountDto.setUser(userDto);

        bankAccountService.create(bankAccountDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody AuthenticationDto dto) {
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(),dto.getPassword()));

            User user = (User) authentication.getPrincipal();

            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtTokenProvider.createToken(user)).body(user);

        }catch (AuthenticationException e){
            log.warn(e.getMessage());
            throw new BadCredentialsException("invalid login or password");
        }
    }
}
