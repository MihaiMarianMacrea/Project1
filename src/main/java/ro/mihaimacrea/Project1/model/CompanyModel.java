package ro.mihaimacrea.Project1.model;

import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
public class CompanyModel {

    private Long id;
    @Size(min = 2, message = "Introduceti minim 2 caractere")
    private String name;
    private String description;
    private Long revenues;
    private Boolean isActive;
    private LocalDateTime incorporationDate;

}
