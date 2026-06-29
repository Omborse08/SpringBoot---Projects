package com.example.GrandTickAutoVi.service;

import com.example.GrandTickAutoVi.globalException.custome.NewsNotFoundException;
import com.example.GrandTickAutoVi.model.News;
import com.example.GrandTickAutoVi.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository repository;

    public void addNews(News news) {
        repository.save(news);
    }

    public boolean updateNews(int id,News news) {
        if (repository.existsById(id)) {
            repository.save(news);
            return true;
        }
        return false;
    }

    public List<News> getAllNews() {
        return repository.findAll();
    }

    public List<News> getNewsByTitle(String title) {
        return repository.findNewsByTitleContains(title);
    }

    public boolean deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public News getById(int id) {
        News news = repository.findById(id).orElse(null);
        if (news != null) {
            return news;
        }
        throw new NewsNotFoundException("News Not Found!");
    }


}
