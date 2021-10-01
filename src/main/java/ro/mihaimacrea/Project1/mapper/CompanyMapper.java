package ro.mihaimacrea.Project1.mapper;

import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.entity.Company;
import ro.mihaimacrea.Project1.model.CompanyModel;

public class CompanyMapper {

    public static CompanyModel entityToModel(Company company) { //BD -> company Microsoft -> city_id = 15 -> Pitesti  -> country_id -> 100 Romania
        return CompanyModel.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .revenues(company.getRevenues())
                .isActive(company.getIsActive())
                .incorporationDate(company.getIncorporationDate())
                .cityName(company.getCity() != null ? company.getCity().getName() : null)
                .countryName(company.getCity() != null && company.getCity().getCountry() != null ? company.getCity().getCountry().getName() : null)
                .build();
        /*
            company -> city -> country
            company.getCity().getCountry().getName()
             company.getCity() != null   && company.getCity().getCountry() != null ?  company.getCity().getCountry().getName() : null
             Pitesti                            Romania
         */
    }

    public static Company modelToEntity(CompanyModel model, City cityFromDB) { // ->ca param  {pitesti, id 15 , country romania}
        return Company.builder()
                .name(model.getName())
                .description(model.getDescription())
                .revenues(model.getRevenues())
                .isActive(model.getIsActive())
                .incorporationDate(model.getIncorporationDate())
                .city(cityFromDB)
                .build();
    }
}
