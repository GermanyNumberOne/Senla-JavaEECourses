package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
public class UserInformationDto extends AbstractDto {
    //private UserDto user;

    private String telephoneNumber;

    private String address;

}
