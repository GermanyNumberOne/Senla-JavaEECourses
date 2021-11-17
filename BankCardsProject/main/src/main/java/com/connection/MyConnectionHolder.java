package com.connection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Getter
@Setter
public class MyConnectionHolder {
    @Autowired
    private Connection connection;

    @PreDestroy
    public void closeConnection() throws SQLException {
        System.out.println("close");
        connection.close();
    }
}
