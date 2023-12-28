package com.cedeczko.app.data;

import com.cedeczko.app.logic.Film;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MovieCache {
    static public Map<String, Film> films = new HashMap<>();
    static public Set<String> genres = new HashSet<>();

    public static void addFilm(Film film) {
        films.put(film.getId(), film);
    }

    public static void addGenre(String genre) {
        genres.add(genre);
    }
}
