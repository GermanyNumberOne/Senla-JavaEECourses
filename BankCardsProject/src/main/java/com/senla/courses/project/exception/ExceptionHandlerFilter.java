package com.senla.courses.project.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (JwtException | IllegalArgumentException e){
            log.warn(e.getMessage());
            setErrorResponse(HttpStatus.BAD_REQUEST, httpServletResponse, e);
        }catch (Exception e){
            log.warn(e.getMessage());
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

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), message);
    }
}
