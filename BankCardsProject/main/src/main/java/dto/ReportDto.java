package dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class ReportDto extends AbstractDto{
    private Boolean isSuccess;

    private List<String> operationCategories;


}
