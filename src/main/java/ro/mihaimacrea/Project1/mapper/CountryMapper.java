package ro.mihaimacrea.Project1.mapper;

import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.model.CountryModel;

public class CountryMapper {

    public static CountryModel entityToModel(Country entity) {
        return CountryModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Country modelToEntity(CountryModel model) {
        return Country.builder()
                .name(model.getName())
                .build();
    }
}
