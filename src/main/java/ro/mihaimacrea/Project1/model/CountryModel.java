package ro.mihaimacrea.Project1.model;

import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class CountryModel {

    private Long id;
    @Size(min = 2, message = "Introduceti minim 2 caractere")
    private String name;
}
