package com.example.DarrensPetitions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DarrensPetitionsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    // Test for the "index" endpoint
    void testIndexView() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("title"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pageTitle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("petitions"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("petitionTitles"));
    }

    @Test
        // Test for the "create" endpoint
    void testCreatePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/create"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Checking for 200 HTTP status
                .andExpect(MockMvcResultMatchers.view().name("create")) // Checking for view name of "create"
                .andExpect(MockMvcResultMatchers.model().attributeExists("title")) // Checking for "title" in the model
                .andExpect(MockMvcResultMatchers.model().attributeExists("pageTitle")); // Checking fpr "pageTitle" in the model
    }

    // Test for the "search" endpoint
    @Test
    void testSearchPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/search"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Checking for 200 HTTP status
                .andExpect(MockMvcResultMatchers.view().name("search"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("title"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pageTitle"));
    }

    // Test for the "result" endpoint
    @Test
    // Check the result page after a petition has been created
    void testResultPage() throws Exception {
        // Creating a petition to be used in the test
        String petitionTitle = "Test Petition";
        String petitionDescription = "Test Description";
        String petitionAuthor = "Test Author";

        // Simulate creating a petition
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .param("petitionTitle", petitionTitle)
                        .param("petitionDescription", petitionDescription)
                        .param("petitionAuthor", petitionAuthor))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection()); // To handle the redirect to the index page

        // Check the result page for the created petition
        mockMvc.perform(MockMvcRequestBuilders.get("/result/{title}", petitionTitle))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("result"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("title"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pageTitle"));
    }

}