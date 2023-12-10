package com.cedeczko.app.data;

import com.cedeczko.app.logic.Film;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Database {
    ArrayList<Film> getFilms() throws SQLException;
    ArrayList<String> getGenres() throws SQLException;
}
