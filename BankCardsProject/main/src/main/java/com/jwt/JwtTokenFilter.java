package com.jwt;

import com.dao.api.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtTokenFilter extends GenericFilterBean {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDao userDao;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);

        if(token != null && jwtTokenProvider.validateToken(token, (HttpServletRequest) servletRequest)){
            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            if(authentication != null){
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        //else throw new AuthenticationException("JWT token is invalid or expired");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
