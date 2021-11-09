package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class BankAccountDto extends AbstractDto {
    private List<CardDto> cards;
    private List<OperationDto> operations;


}
