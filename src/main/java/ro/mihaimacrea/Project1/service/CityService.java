package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.mapper.CityMapper;
import ro.mihaimacrea.Project1.model.CityModel;
import ro.mihaimacrea.Project1.repositories.CityRepository;
import ro.mihaimacrea.Project1.repositories.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    //Return a List of Cities
    public List<CityModel> getCities(){
        return cityRepository.findAll()
                .stream()
                .map(entity -> CityMapper.entityToModel(entity)).collect(Collectors.toList());
    }

    public void save(CityModel cityModel) {
        Country country = countryRepository.findById(cityModel.getCountryId()).orElse(null);

        City city = CityMapper.modelToEntity(cityModel, country);
        cityRepository.save(city);
    }
}
