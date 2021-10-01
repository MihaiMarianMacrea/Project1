package ro.mihaimacrea.Project1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyModel {

    private Long id;
    @Size(min = 2, message = "Introduceti minim 2 caractere")
    private String name;
    private String description;
    private Long revenues;
    private Boolean isActive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incorporationDate;

    private Long cityId;
    private String cityName;
    private String countryName;
}
