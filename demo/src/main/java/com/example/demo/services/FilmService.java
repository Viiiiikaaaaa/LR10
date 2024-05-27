package com.example.demo.services;

import com.example.demo.models.Film;
import com.example.demo.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    FilmRepository filmRepository;

    @Autowired
    public FilmService (FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public void createFilm(Film film){
        filmRepository.createFilm(film);
    }

    public void updateFilm(Film film){
        filmRepository.updateFilm(film);
    }

    public void deleteFilm(int id){
        filmRepository.deleteFilm(id);
    }

    public Film findFilmById(int id){
        return filmRepository.getFilmByYear(id).get();
    }
}
