package com.klef.soa.endsemexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.endsemexam.entity.Tourist;
import com.klef.soa.endsemexam.repository.TouristRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristRepository touristRepository;

    private static final String VALID_TOKEN =
            "TOURIST-TEST-8F3A-2026";

    @GetMapping("/tourists")
    public List<Tourist> getAllTourists(
            @RequestHeader(value = "token", required = false) String token) {

        if (token == null || !token.equals(VALID_TOKEN)) {
            throw new RuntimeException(
                    "Unauthorized: Invalid token provided");
        }

        return touristRepository.findAll();
    }

    @PostMapping("/tourists")
    public Tourist addTourist(
            @RequestHeader(value = "token", required = false) String token,
            @RequestBody Tourist tourist) {

        if (token == null || !token.equals(VALID_TOKEN)) {
            throw new RuntimeException(
                    "Unauthorized: Invalid token provided");
        }

        return touristRepository.save(tourist);
    }
}