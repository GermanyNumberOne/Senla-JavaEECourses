package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class UserDto extends AbstractDto {
    private String name;

    private String surname;

    private List<CardDto> cards;

    private UserInformationDto userInfo;
}
