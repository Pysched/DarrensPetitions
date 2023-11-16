package com.example.DarrensPetitions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {
    static List<String> petitions = new ArrayList<>();
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Darren's Petitions");
        model.addAttribute("pageTitle", "Index Page");
        model.addAttribute("petitions", petitions);
        return "index";
    }

    @RequestMapping(value="create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("title", "Create a Petition");
        model.addAttribute("pageTitle", "Create Page");
        return "create";
    }

    @RequestMapping(value="create", method = RequestMethod.POST)
    public String processCreate(@RequestParam String petitionTitle){
        petitions.add(petitionTitle);
        return "redirect:";
    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("title", "Search for a Petition");
        model.addAttribute("pageTitle", "Search Page");
        return "search";
    }
    @RequestMapping("/result")
    public String result(Model model){
        model.addAttribute("title", "Review Petition Result");
        model.addAttribute("pageTitle", "Result Page");
        return "result";
    }
}