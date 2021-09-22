package ro.mihaimacrea.Project1.model;

import lombok.Data;
import javax.validation.constraints.Size;


@Data
public class EmployeeModel {


    private Long id;
    @Size(min = 2, message = "Introduceti minim 2 caractere")
    private String name;
    private Integer age;
    private String email;
    private Integer salary;
    private Boolean isActive;


}
