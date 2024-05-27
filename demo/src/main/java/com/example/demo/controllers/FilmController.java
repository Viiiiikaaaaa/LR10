package com.example.demo.controllers;

import com.example.demo.models.Film;
import com.example.demo.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {
    FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @PostMapping("/film")
    public String createFilm(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam Integer year,
            @RequestParam String slogan,
            @RequestParam String genres
    ){
        filmService.createFilm(new Film(id,name,year,slogan,genres));
        return "Фильм добавлен!";
    }

    @PatchMapping("/film/update")
    public String updateFilm(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam Integer year,
            @RequestParam String slogan,
            @RequestParam String genres
    ){
        filmService.updateFilm(new Film(id,name,year,slogan,genres));
        return "Фильм с id " + id + " изменен";
    }

    @DeleteMapping("/film/delete/{id}")
    public String deleteFilm(
            @PathVariable Integer id
    ){
        filmService.deleteFilm(id);
        return "Фильм с id" + id + "удален";
    }

    @GetMapping("film/{id}")
    public Film findById(@PathVariable Integer id){
        return filmService.findFilmById(id);
    }
}
