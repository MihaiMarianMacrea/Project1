package ro.mihaimacrea.Project1.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.mihaimacrea.Project1.model.CompanyModel;
import ro.mihaimacrea.Project1.service.CityService;
import ro.mihaimacrea.Project1.service.CompanyService;

import javax.validation.Valid;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    @NonNull
    private final CompanyService companyService;
    @NonNull
    private final CityService cityService;

    @GetMapping("/all")
    public String getCompanies (Model model) {
        model.addAttribute("companyes", companyService.getCompanies());
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("companyModel", new CompanyModel());
        return "company";
    }

    @PostMapping("/save")
    public String saveCity(Model model, @Valid @ModelAttribute CompanyModel companyModel,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyes",  companyService.getCompanies());
            model.addAttribute("cities", cityService.getCities());
            return "company";
        }

        companyService.save(companyModel);

        return "redirect:/company/all";
    }
}
