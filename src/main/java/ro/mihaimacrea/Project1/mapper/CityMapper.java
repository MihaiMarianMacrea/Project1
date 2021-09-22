package ro.mihaimacrea.Project1.mapper;

import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.model.CityModel;

public class CityMapper {

    public static CityModel entityToModel(City entity) {
        return CityModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .population(entity.getPopulation())
                .build();
    }

    public static City modelToEntity(CityModel model) {
        return City.builder()
                .name(model.getName())
                .population(model.getPopulation())
                .build();
    }
}
