package com.example.carshowroomfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = Logger.getLogger(IndexController.class.getName());

    @GetMapping("/")
    public String index(Model model) {
        List cars = restTemplate.getForObject("http://car-service/cars", List.class);
        List showrooms = restTemplate.getForObject("http://showroom-service/showrooms", List.class);

        logger.info("Cars: " + cars);
        logger.info("Showrooms: " + showrooms);

        model.addAttribute("cars", cars);
        model.addAttribute("showrooms", showrooms);
        model.addAttribute("search", new SearchForm());
        model.addAttribute("searchResults", null);

        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String make, @RequestParam String model, Model modelAttr) {
        List searchResults = restTemplate.getForObject("http://car-service/cars/search?make=" + make + "&model=" + model, List.class);

        modelAttr.addAttribute("cars", restTemplate.getForObject("http://car-service/cars", List.class));
        modelAttr.addAttribute("showrooms", restTemplate.getForObject("http://showroom-service/showrooms", List.class));
        modelAttr.addAttribute("search", new SearchForm(make, model));
        modelAttr.addAttribute("searchResults", searchResults);

        return "index";
    }
}

