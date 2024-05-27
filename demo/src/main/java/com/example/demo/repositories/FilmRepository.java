package com.example.demo.repositories;

import com.example.demo.models.Film;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FilmRepository {
    List<Film> films;

    public void createFilm (Film film){
        films.add(film);
    }

    public void updateFilm (Film film){
        films.set(film.getId()-1,film);
    }

    public void deleteFilm(int id){
        Iterator<Film> filmIterator = films.iterator();
        while (filmIterator.hasNext()){
            if(filmIterator.next().getId()==id)
                filmIterator.remove();
        }
    }

    public Optional<Film> getFilmByYear(int id){
        for (Film film : films){
            if (film.getId()==id){
                return Optional.of(film);
            }
        }
        return Optional.empty();
    }

    @PostConstruct
    public void init(){
        films = new ArrayList<>(Arrays.asList(
                new Film(1,"1+1",2011, "Иногда вы должны заглянуть в чужой мир, чтобы узнать, чего не хватает в своём",
                        "драма, комедия"),
                new Film(2,"Форрест Гамп", 1994, "Мир уже никогда не будет прежним, после того как вы увидите его глазами Форреста Гампа",
                        "драма, комедия, мелодрама, история, военный"),
                new Film(3,"Остров проклятых", 2009, "Некоторые места никогда не отпустят тебя", "триллер, детектив, драма"),
                new Film(4,"Легенда", 2015, "Преступление – как профессия. Взлет и падение легендарных близнецов Крэй", "криминал, триллер, драма"),
                new Film(5,"Синистер", 2012, "Увидевший его не спасётся","ужасы"),
                new Film(6,"Шоу Трумана", 1998, "Он в прямом эфире и даже не подозревает...", "драма, комедия"),
                new Film(7,"Начало", 2010, "Твой разум - место преступления","фантастика, боевик, триллер, драма, детектив"),
                new Film(8,"Оппенгеймер", 2023, "-", "биография, драма, история"),
                new Film(9,"Довод", 2020, "Время уходит", "фантастика, боевик, триллер"),
                new Film(10,"Исходный код", 2011, "Считай каждую секунду", "фантастика, боевик, триллер, драма"),
                new Film(11,"Социальная сеть", 2010, "Нельзя завести 500 миллионов друзей, не нажив ни одного врага", "драма, биография")
        ));
    }

}
