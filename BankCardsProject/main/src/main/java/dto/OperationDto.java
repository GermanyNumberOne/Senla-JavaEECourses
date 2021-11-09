package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
public class OperationDto extends AbstractDto {
    private Long cost;

    private ReportDto report;


}
