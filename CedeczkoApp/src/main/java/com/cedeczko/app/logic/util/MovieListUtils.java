package com.cedeczko.app.logic.util;

import com.cedeczko.app.data.Database;
import com.cedeczko.app.data.DatabaseConnector;
import com.cedeczko.app.logic.Film;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MovieListUtils {
    static Database db = new DatabaseConnector();

    public static ArrayList<String[]> getData() {
        var data = new ArrayList<String[]>();
        ArrayList<Film> films = db.getFilms();
        for(var film: films) {
            String title = film.getTitle();
            String director = film.getDirector();
            String genres = film.getGenres().toString();
            genres = genres.substring(1, genres.length()-1);
            String year = Integer.toString(film.getYear());
            data.add(new String[]{title, director, genres, year});
        }
        return data;
    }

    public static ArrayList<String> getGenres() {
        ArrayList<String> genres = db.getGenres();
        genres.add(0, "");
        return genres;
    }
    public static String[] getFields() {
        return new String[]{"Tytuł", "Reżyser", "Gatunek", "Rok"};
    }
    public static ArrayList<String[]> limitTableData(SearchParams searchParams, ArrayList<String[]> data) {
        return (ArrayList<String[]>)data.stream()
                .filter(searchParams::listIncludesParams)
                .collect(Collectors.toList());
    }
}
