package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
public class CardDto extends AbstractDto {
    private String number;

    private Short password;

    private Long money;

    //private UserDto user;



}
