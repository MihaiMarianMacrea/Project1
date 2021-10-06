package ro.mihaimacrea.Project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaimacrea.Project1.entity.Company;
import ro.mihaimacrea.Project1.entity.Employee;
import ro.mihaimacrea.Project1.entity.EmployeeCompany;
import ro.mihaimacrea.Project1.mapper.EmployeeMapper;
import ro.mihaimacrea.Project1.model.EmployeeModel;
import ro.mihaimacrea.Project1.repositories.CompanyRepository;
import ro.mihaimacrea.Project1.repositories.EmployeeCompanyRepository;
import ro.mihaimacrea.Project1.repositories.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeCompanyRepository employeeCompanyRepository;



       /*
            1.000.000 employee  -> ma duc de 1.mil ori in BD in employee_comapny pt a-mi aduce informatiile
            Eficient:  sa nu am queryuri in for, map

            1 singura data la baza de date -> imi stochez toate informatiile asa  cum am nevoie iar in for ma folosesc de lucrul stocat pt a gasi

         */


    public List<EmployeeModel> getEmployees() {

        Map<Long, List<EmployeeCompany>> employeeIdToCompaniesMap = employeeCompanyRepository.findAll()  //1 singur query
                .stream()
                .collect(Collectors.groupingBy(ec -> ec.getEmployee().getId()));

        /*

            e1       -> List<EC>
            e2       -> List<EC>
            ...
            e1000000 -> List<EC>
         */

        return employeeRepository.findAll() //tabela employee E1, E2, E3    ->    EC1,Ec2,Ec3    Ec4,Ec5,  Ec8,9
                .stream()
                .map(employee -> {
                    List<EmployeeCompany> employeeCompanies = employeeIdToCompaniesMap.get(employee.getId());
                    EmployeeModel employeeModel = EmployeeMapper.entityToModel(employee, employeeCompanies);
                    return employeeModel;
                })
                .collect(Collectors.toList());
    }





//    public List<EmployeeModel> getEmployees() {
//
//        return employeeRepository.findAll() //tabela employee E1, E2, E3    ->    EC1,Ec2,Ec3    Ec4,Ec5,  Ec8,9
//                .stream()
//                .map(employee -> {
//                    //ec -> id,  employee_id, company_id
//                    //E1  ->  employeeCompanyRepo.findByEmployeeId -> Ec1, Ec2, Ec3 .stream.map. numele -> concat
//                    List<String> companyNames = employeeCompanyRepository.findByEmployeeId(employee.getId())
//                            .stream()
//                            .map(employeeCompany -> employeeCompany.getCompany().getName())
//                            .collect(Collectors.toList());
//
//                    EmployeeModel employeeModel = EmployeeMapper.entityToModel(employee, companyNames);
//                    return employeeModel;
//                })
//                .collect(Collectors.toList());
//    }

    public void save(EmployeeModel employeeModel, Long employeeId) {
        //new -> 0,   celelalte -> id=7, 10
        Employee employee = EmployeeMapper.modelToEntity(employeeModel, employeeId);
        Employee savedEmployee = employeeRepository.save(employee);//salvam in tabela lui -> employee 10
        saveEmployeeCompanies(employeeModel.getCompanyIds(), savedEmployee);
    }

    private void saveEmployeeCompanies(List<Long> companyIds, Employee savedEmployee) {
//        companyIds.stream()
//                .map(companyId -> companyRepository.findById(companyId))
//                .collect(Collectors.toList());//  1 mil companii -> ar fi facut 1 mil query-uri


        //stergem si acoperim si cazul il care debiffezi companiile employeeului
        employeeCompanyRepository.deleteByEmployeeId(savedEmployee.getId());

        List<Company> selectedCompanies = companyRepository.findByIdIn(companyIds);  //id 1,2,3  => entitatile C1, C2, C3
        List<EmployeeCompany> employeeCompanies = selectedCompanies.stream()
                .map(selectedCompany -> {
                    EmployeeCompany employeeCompany = new EmployeeCompany();
                    employeeCompany.setEmployee(savedEmployee); //10
                    employeeCompany.setCompany(selectedCompany);
                    return employeeCompany;
                }).collect(Collectors.toList());
        employeeCompanyRepository.saveAll(employeeCompanies);
    }

    public EmployeeModel getModelById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        List<EmployeeCompany> employeeCompanies = employeeCompanyRepository.findByEmployeeId(employeeId);
        return EmployeeMapper.entityToModel(employee, employeeCompanies);
    }

    public void deleteEmployee(Long employeeId) {
        employeeCompanyRepository.deleteByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
    }
}
