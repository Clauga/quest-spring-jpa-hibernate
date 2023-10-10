package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {

    // TODO : get school repository by dependency injection
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    @GetMapping("/schools")
    public String getAll(Model model) {

        // TODO : find all schools
        Iterable<School> schools = schoolRepository.findAll();
        model.addAttribute("schools", schools);
        return "schools";
    }

    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

        // TODO : find one school by id
        School school = schoolRepository.findById(id).orElse(null);

        return "school";
    }

    @PostMapping("/school")
    public String postSchool(@ModelAttribute School school) {

        // TODO : create or update a school
        schoolRepository.save(school);

        return "redirect:/schools";
    }

    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {

        // TODO : delete a school
        schoolRepository.deleteById(id);

        return "redirect:/schools";
    }
}
