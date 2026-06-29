package com.example.GrandTickAutoVi.controller;

import com.example.GrandTickAutoVi.model.News;
import com.example.GrandTickAutoVi.service.NewsExplainerAi;
import com.example.GrandTickAutoVi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news/public")
@CrossOrigin(origins = "*")
public class NewsControllerPublicPanel {

    private final NewsService service;
    private final NewsExplainerAi ai;

    @GetMapping("/allNews")
    public ResponseEntity<List<News>> getAllNews() {
        return new ResponseEntity<>(service.getAllNews(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<News>> getByTitle(@RequestParam String title) {
        return new ResponseEntity<>(service.getNewsByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/explainer")
    public ResponseEntity<String> explainerAi(@RequestHeader int id,@RequestHeader String user_message) {
        String message = ai.explainer(service.getById(id).getAbout(),user_message);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
