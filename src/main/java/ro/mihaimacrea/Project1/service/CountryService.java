package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.mapper.CountryMapper;
import ro.mihaimacrea.Project1.model.CountryModel;
import ro.mihaimacrea.Project1.repositories.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return a list of Countries
    public List<CountryModel> getCountries() {
        return countryRepository.findAll()
                .stream()
                .map(entity -> CountryMapper.entityToModel(entity)).collect(Collectors.toList());
    }

    public void save(CountryModel countryModel) {
        Country country = CountryMapper.modelToEntity(countryModel);
        countryRepository.save(country);
    }
}
