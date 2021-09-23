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
import ro.mihaimacrea.Project1.model.CountryModel;
import ro.mihaimacrea.Project1.service.CountryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    @NonNull
    private final CountryService countryService;

    @GetMapping("/all")
    public String getCountries(Model model) {
        model.addAttribute("countryes", countryService.getCountries());
        model.addAttribute("countryModel", new CountryModel());
        return "country";
    }

    @PostMapping("/save")
    public String saveCountry(Model model, @Valid @ModelAttribute CountryModel countryModel,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contries", countryService.getCountries());
            return "country";
        }
        countryService.save(countryModel);
        return "redirect:/country/all";
    }
}
