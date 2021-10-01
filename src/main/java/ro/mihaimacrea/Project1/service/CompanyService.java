package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.entity.Company;
import ro.mihaimacrea.Project1.mapper.CompanyMapper;
import ro.mihaimacrea.Project1.model.CompanyModel;
import ro.mihaimacrea.Project1.repositories.CityRepository;
import ro.mihaimacrea.Project1.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<CompanyModel> getCompanyes() {
        return companyRepository.findByOrderByCityCountryNameAscNameAsc() //company -> city -> country
                .stream()
                .map(company -> CompanyMapper.entityToModel(company)).collect(Collectors.toList());
    }

    public void save(CompanyModel companyModel) { // Microsoft, ...., 20.09.2021,  cityId = 1. -> ENTITATEA CITY
        City cityFromDB = cityRepository.findById(companyModel.getCityId()).orElse(null);

        Company company = CompanyMapper.modelToEntity(companyModel, cityFromDB);
        companyRepository.save(company);
    }
}

