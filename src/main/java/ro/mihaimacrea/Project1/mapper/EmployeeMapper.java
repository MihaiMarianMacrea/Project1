package ro.mihaimacrea.Project1.mapper;

import ro.mihaimacrea.Project1.entity.Employee;
import ro.mihaimacrea.Project1.entity.EmployeeCompany;
import ro.mihaimacrea.Project1.model.EmployeeModel;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeModel entityToModel(Employee employee, List<EmployeeCompany> employeeCompanies) {
        return EmployeeModel.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .isActive(employee.getIsActive())
                .allCompanyNames(employeeCompanies != null ? getCompanyNames(employeeCompanies) : null)
                .companyIds(employeeCompanies != null ? getCompanyIds(employeeCompanies) : null)
                .build();
    }

    private static List<Long> getCompanyIds(List<EmployeeCompany> employeeCompanies) {
        return employeeCompanies
                .stream()
                .map(employeeCompany -> employeeCompany.getCompany().getId())
                .collect(Collectors.toList());
    }

    private static List<String> getCompanyNames(List<EmployeeCompany> employeeCompanies) {
        return employeeCompanies
                .stream()
                .map(employeeCompany -> employeeCompany.getCompany().getName())
                .collect(Collectors.toList());
    }

    public static Employee modelToEntity(EmployeeModel model, Long employeeId) {
        return Employee.builder()
                .id(employeeId == 0 ? null : employeeId)
                .name(model.getName())
                .age(model.getAge())
                .email(model.getEmail())
                .salary(model.getSalary())
                .isActive(model.getIsActive())
                .build();
    }


}
