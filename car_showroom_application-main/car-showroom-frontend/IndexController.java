package com.example.carshowroomfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        List cars = restTemplate.getForObject("http://car-service/cars", List.class);
        List showrooms = restTemplate.getForObject("http://showroom-service/showrooms", List.class);
        model.addAttribute("cars", cars);
        model.addAttribute("showrooms", showrooms);
        return "index";
    }
}

