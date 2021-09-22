package ro.mihaimacrea.Project1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CompanyController {
    @GetMapping("/companies")
    public String getCompanie (Model model) {


        return "company";
    }
}
