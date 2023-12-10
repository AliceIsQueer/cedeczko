package com.cedeczko.app.data;

import com.cedeczko.app.logic.Film;

import java.util.ArrayList;

public interface Database {
    public ArrayList<Film> getFilms();
    public ArrayList<String> getGenres();
}
