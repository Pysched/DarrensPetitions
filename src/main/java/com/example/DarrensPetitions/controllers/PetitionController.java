package com.example.DarrensPetitions.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PetitionController {
    static List<Petition> petitions = new ArrayList<>(); // List to store petition objects
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Darren's Petitions");
        model.addAttribute("pageTitle", "View Petitions");

        // Get a list of petition titles and add it to the model
        List<String> petitionTitles = petitions.stream()
                .map(Petition::getPetitionTitle)
                .toList();
        model.addAttribute("petitions", petitions);
        model.addAttribute("petitionTitles", petitionTitles);
        return "index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("title", "Create a Petition");
        model.addAttribute("pageTitle", "Create Petition");
        return "create";
    }

    @PostMapping("/create")
    public String processCreate(
            @RequestParam String petitionTitle,
            @RequestParam String petitionDescription,
            @RequestParam String petitionAuthor){
        Petition petition = new Petition(petitionTitle, petitionDescription, petitionAuthor);
        petitions.add(petition); // Add the petition to the list of petitions
        return "redirect:/"; // Redirect to index page
    }

    @GetMapping("/result/{petitionTitle}")// handle the GET request to display the result of the search
    public String result(@PathVariable String petitionTitle, Model model){
        model.addAttribute("title", "Review Petition Result");
        model.addAttribute("pageTitle", "Result Page");

        Petition isPetition = null;
        for (Petition petition : petitions) { // loop through the list of petitions to find the petition with the matching title
            if (petition.getPetitionTitle().equals(petitionTitle)) {
                isPetition = petition;
                break;
            }
        }
        if (isPetition != null) { // if the petition is found, add it to the model
            model.addAttribute("petition", isPetition);
            return "result";
        } else {
            // Handle invalid petitionTitle - return to index page
            return "index";
        }

    }

    @PostMapping("/result/{petitionTitle}") // Handle the POST request to sign a petition
    public String processSignature(@PathVariable String petitionTitle, @ModelAttribute("petition") Petition petition) {
        for (Petition p : petitions) {
            if (p.getPetitionTitle().equals(petitionTitle)) {
                // Create a new Signature object
                Signature signature = new Signature(petition.getSignupSignature(), petition.getSignupEmail());
                p.addSignature(signature); // Add the signature to the signatures list & increment the number of signatures

                return "redirect:/result/" + petitionTitle;
            }
        }
        return "index"; // Error handling - return to index page
    }

    @GetMapping("/search") // Handle the initial search page request
    public String searchPage(Model model) {
        int totalPetitions = petitions.size(); // Get the total number of petitions
        int totalSignatures = petitions.stream().mapToInt(petition -> petition.getSignatures().size()).sum(); // Get the total number of signatures
        model.addAttribute("title", "Search for a Petition");
        model.addAttribute("pageTitle", "Search Petitions");
        model.addAttribute("totalPetitions", totalPetitions);
        model.addAttribute("totalSignatures", totalSignatures);
        return "search"; // Map to "search.html"
    }

    @PostMapping("/search") // Handle the POST request for search and redirect to results page
    public String searchRedirect(@RequestParam String searchTerm) {
        return "redirect:/results?searchTerm=" + searchTerm;
    }

    @GetMapping("/results") // Handle the GET request to display the search results
    public String searchResults(
            @RequestParam(name = "searchTerm", required = false)
            String searchTerm, Model model) {
        model.addAttribute("title", "Search Results");
        model.addAttribute("pageTitle", "Search Results");
        model.addAttribute("searchTerm", searchTerm);

        if(searchTerm == null || searchTerm.isEmpty()) {
            model.addAttribute("noResultsMessage", "No search term entered. Please enter a search term.");
            return "results"; // Redirect to search page if no search term is entered
        }

        // Perform filtering and determine if results exist
        List<Petition> searchResults = petitions.stream()
                // filter to only include petitions that contain the search term in the title or description
                .filter(petition -> petition.getPetitionTitle().contains(searchTerm)
                        || petition.getPetitionDescription().contains(searchTerm)
                        || petition.getPetitionAuthor().contains(searchTerm))
                .collect(Collectors.toList());

            // Add the search results to the model
            model.addAttribute("searchResults", searchResults);
            model.addAttribute("noResults", searchResults.isEmpty());
            model.addAttribute("hasResults", !searchResults.isEmpty());
            return "results"; // Map to "results.html"
        }
    }