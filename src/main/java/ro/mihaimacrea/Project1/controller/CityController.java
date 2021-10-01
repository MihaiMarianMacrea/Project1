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
import ro.mihaimacrea.Project1.entity.Country;
import ro.mihaimacrea.Project1.model.CityModel;
import ro.mihaimacrea.Project1.service.CityService;
import ro.mihaimacrea.Project1.service.CountryService;
import ro.mihaimacrea.Project1.validator.CityPopulationValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    @NonNull
    private final CityService cityService;

    @NonNull
    private final CountryService countryService;

    @NonNull
    private final CityPopulationValidator cityPopulationValidator;


    @GetMapping("/all")
    public String getCities(Model model) {
        model.addAttribute("cities",  cityService.getCities());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("cityModel", new CityModel());
        return "city";
    }

    @PostMapping("/save")
    public String saveCity(Model model, @Valid @ModelAttribute CityModel cityModel,
                           BindingResult bindingResult) {
        cityPopulationValidator.validate(cityModel, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("cities",  cityService.getCities());
            model.addAttribute("countries", countryService.getCountries());
            return "city";
        }

        cityService.save(cityModel);

        return "redirect:/city/all";
    }
}
