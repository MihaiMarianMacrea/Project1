package ro.mihaimacrea.Project1.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ro.mihaimacrea.Project1.model.CityModel;

@Component
public class CityPopulationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CityModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CityModel cityModel = (CityModel) target;
        if (cityModel.getPopulation() == null ||
                cityModel.getPopulation() < 30000 ||
                cityModel.getPopulation() > 100000 ||
                cityModel.getPopulation() % 30 != 0) {
            errors.rejectValue("population", "error.population.validation");
        }
    }
}
