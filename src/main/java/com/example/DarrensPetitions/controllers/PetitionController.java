package com.example.DarrensPetitions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetitionController {

    @RequestMapping("/")
    // Model is used to pass data to the view
    public String index(Model model){
        // Add attributes to the model
        model.addAttribute("title", "Darren's Petitions");
        model.addAttribute("pageTitle", "Index Page");
        return "index"; // Returns the view name index to render the HTML page
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("title", "Create a Petition");
        model.addAttribute("pageTitle", "Create Page");
        return "create"; // Returns the view name create to render the HTML page
    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("title", "Search for a Petition");
        model.addAttribute("pageTitle", "Search Page");
        return "search"; // Returns the view name search to render the HTML page
    }

    @RequestMapping("/result")
    public String result(Model model){
        model.addAttribute("title", "Review Petition Result");
        model.addAttribute("pageTitle", "Result Page");
        return "result"; // Returns the view name result to render the HTML page
    }
}