package com.example.GrandTickAutoVi.controller;

import com.example.GrandTickAutoVi.globalException.custome.NewsNotFoundException;
import com.example.GrandTickAutoVi.model.News;
import com.example.GrandTickAutoVi.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NewsControllerAdminPanel {
    private final NewsService service;

    @PostMapping("/post")
    public ResponseEntity<String> addNews(@RequestBody @Valid News news) {
        service.addNews(news);
        return new ResponseEntity<>("News Added!", HttpStatus.CREATED);
    }

    @PutMapping("/put")
    public ResponseEntity<String> updateNews(@RequestBody @Valid News news) {
        if (service.updateNews(news.getId(),news)) {
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        throw new NewsNotFoundException("No News Available With This Id: "+news.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        if (service.deleteById(id)) {
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        throw new NewsNotFoundException("No News Available With This Id: "+id);
    }
}
