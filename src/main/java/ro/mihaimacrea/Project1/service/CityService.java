package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.mapper.CityMapper;
import ro.mihaimacrea.Project1.model.CityModel;
import ro.mihaimacrea.Project1.repositories.CityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    //Return a List of Cities
    public List<CityModel> getCities(){
        return cityRepository.findAll()
                .stream()
                .map(entity -> CityMapper.entityToModel(entity)).collect(Collectors.toList());
    }

    public void save(CityModel cityModel) {
        City city = CityMapper.modelToEntity(cityModel);
        cityRepository.save(city);
    }
}
