package com.exception;

import com.exception.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@Getter
@Setter
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Autowired
    private ObjectMapper mapper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (JwtException | IllegalArgumentException e){
            setErrorResponse(HttpStatus.BAD_REQUEST, httpServletResponse, e);
        }catch (Exception e){
            setErrorResponse(HttpStatus.FORBIDDEN, httpServletResponse, e);
        }
    }

    private void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable throwable) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");

        ErrorMessage message = new ErrorMessage(
                status.value(),
                new Date(),
                throwable.getMessage(),
                throwable.getLocalizedMessage()
        );

        mapper.writeValue(response.getOutputStream(), message);
    }
}
