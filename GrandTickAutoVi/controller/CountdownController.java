package com.example.GrandTickAutoVi.controller;

import com.example.GrandTickAutoVi.model.CountdownAndTime;
import com.example.GrandTickAutoVi.service.CountdownService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/countdown")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CountdownController {
    private final CountdownService service;

    @GetMapping()
    public ResponseEntity<CountdownAndTime> countdown(@RequestParam(defaultValue = "utc") String location) {
        return new ResponseEntity<>(service.countdownAndTime(location), HttpStatus.OK);
    }
}
