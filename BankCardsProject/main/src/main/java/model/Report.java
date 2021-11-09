package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import model.enums.OperationCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Component
public class Report extends BaseEntity {

    private Boolean isSuccess;

    private List<OperationCategories> operationCategories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(isSuccess, report.isSuccess) && Objects.equals(operationCategories, report.operationCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSuccess, operationCategories);
    }
}
