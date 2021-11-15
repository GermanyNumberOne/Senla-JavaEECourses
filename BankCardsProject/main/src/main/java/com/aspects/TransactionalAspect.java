package com.aspects;

import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Aspect
@Component
@AllArgsConstructor
public class TransactionalAspect {
    private final Connection connection;

    @Around("@annotation(com.annotations.Transaction)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            connection.setAutoCommit(false);
            Object proceed = joinPoint.proceed();
            connection.commit();
            return proceed;
        } catch (RuntimeException e) {
            connection.rollback();
            throw e;
        } catch (Exception e) {
            connection.commit();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
