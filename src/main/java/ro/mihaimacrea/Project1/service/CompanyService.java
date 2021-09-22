package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.Company;
import ro.mihaimacrea.Project1.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

        public List<Company> getCities(){
        return companyRepository.findAll();
    }
}
