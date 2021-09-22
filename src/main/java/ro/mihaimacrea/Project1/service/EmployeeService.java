package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.City;
import ro.mihaimacrea.Project1.entity.Employee;
import ro.mihaimacrea.Project1.repositories.CityRepository;
import ro.mihaimacrea.Project1.repositories.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Return a List of Employees
    public List<Employee> getCities(){
        return employeeRepository.findAll();
    }
}
