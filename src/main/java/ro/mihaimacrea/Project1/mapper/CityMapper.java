package ro.mihaimacrea.Project1.mapper;

import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.model.CityModel;

public class CityMapper {

    public static CityModel entityToModel(City entity) {
        return CityModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .population(entity.getPopulation())
                .countryId(entity.getCountry() != null ? entity.getCountry().getId() : null)
                .countryName(entity.getCountry() != null ? entity.getCountry().getName() : null)
                .build();
    }

    public static City modelToEntity(CityModel model, Country country) {
        return City.builder()
                .name(model.getName())
                .population(model.getPopulation())
                .country(country)
                .build();
    }
}
