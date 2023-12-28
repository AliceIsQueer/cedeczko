package com.cedeczko.app.data;

import com.cedeczko.app.logic.Film;

import java.util.HashMap;


public class MovieCache {
    static public HashMap<String, Film> films = new HashMap<>();

    public static void addFilm(Film film) {
        films.put(createFilmId(film), film);
    }

    private static String createFilmId(Film film) {
        return film.getTitle().toLowerCase().replace(" ", "") + "_" + film.getDirector().toLowerCase().replace(" ", "");
    }

}
