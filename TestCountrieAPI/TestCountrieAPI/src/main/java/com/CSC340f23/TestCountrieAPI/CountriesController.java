package com.CSC340f23.TestCountrieAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jacob Crews
 */
@RestController
public class CountriesController {

    /**
     * Get a list of countries from REST countries and make them available at
     * this endpoint.
     *
     * @return json array
     */
    @GetMapping("/name")
    public Object getName() {
        try {
            String url = "https://restcountries.com/v3.1/all?fields=name";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonNames = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonNames);

            //Print the whole response to console.
            System.out.println(root);

            return root;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CountriesController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /name";
        }
    }
}
