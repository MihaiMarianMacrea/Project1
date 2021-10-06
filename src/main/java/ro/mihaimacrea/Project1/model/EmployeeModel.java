package ro.mihaimacrea.Project1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private Long id;
    @Size(min = 2, message = "Introduceti minim 2 caractere")
    private String name;
    private Integer age;
    private String email;
    private Integer salary;
    private Boolean isActive;
    private List<Long> companyIds;
    private List<String> allCompanyNames;

}
