package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.repositories.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return a list of Countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
