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
public class CountryModel {

    private Long id;
    @Size(min = 2, message = "{error.min.two.char}")
    private String name;
}
