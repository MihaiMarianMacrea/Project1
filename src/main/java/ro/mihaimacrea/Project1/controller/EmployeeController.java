package ro.mihaimacrea.Project1.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.mihaimacrea.Project1.model.EmployeeModel;
import ro.mihaimacrea.Project1.service.CompanyService;
import ro.mihaimacrea.Project1.service.EmployeeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @NonNull
    private final EmployeeService employeeService;
    @NonNull
    private final CompanyService companyService;

    @GetMapping("/all")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees()); // [EM0, EM1, EM2, EM3]
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("employeeModel", new EmployeeModel());
        return "employee";
    }

    @PostMapping("/save/{employeeId}")
    public String saveEmployee(Model model, @Valid @ModelAttribute EmployeeModel employeeModel,
                               BindingResult bindingResult, @PathVariable Long employeeId) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.getEmployees());
            model.addAttribute("companies", companyService.getCompanies());
            return "employee";
        }
        employeeService.save(employeeModel, employeeId);
        return "redirect:/employee/all";
    }

    @GetMapping("/edit/{employeeId}")
    public String getEmployeeById(@PathVariable Long employeeId, Model model) {
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("employeeModel", employeeService.getModelById(employeeId));
        return "employeeEdit";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employee/all";
    }
}

/*
    tabelul cu empl
    form -> unde ai companii

 */
