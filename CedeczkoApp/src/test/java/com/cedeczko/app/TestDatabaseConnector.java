package com.cedeczko.app;

import com.cedeczko.app.data.DatabaseConnector;
import com.cedeczko.app.logic.Film;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestDatabaseConnector {
    @Test
    public void testValidConnection() {
        DatabaseConnector db = new DatabaseConnector();

        ArrayList<Film> films = db.getFilms();

        assertTrue(films.get(0).getTitle().equals("The Shawshank Redemption"));
    }
}
