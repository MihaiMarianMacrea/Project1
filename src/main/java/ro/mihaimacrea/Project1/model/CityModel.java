package ro.mihaimacrea.Project1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityModel {

    private Long id;

    @Size(min = 2, message = "{error.min.two.char}")
    private String name;

    //validarile custom se pot face si cu adnotari
    //  https://www.baeldung.com/spring-mvc-custom-validator
    private Long population; //vreau ca populatia sa fie intre 30.000 si 100.000 si sa fie multiplu de 30

}
