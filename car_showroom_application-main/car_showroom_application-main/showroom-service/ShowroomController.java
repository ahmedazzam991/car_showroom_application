package com.example.showroomservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showrooms")
public class ShowroomController {

    @Autowired
    private ShowroomRepository showroomRepository;

    @GetMapping
    public List<Showroom> getAllShowrooms() {
        return showroomRepository.findAll();
    }

    @PostMapping
    public Showroom createShowroom(@RequestBody Showroom showroom) {
        return showroomRepository.save(showroom);
    }
}

