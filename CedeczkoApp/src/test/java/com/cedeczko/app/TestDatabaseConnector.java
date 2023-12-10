package com.cedeczko.app;

import com.cedeczko.app.data.DatabaseConnector;
import com.cedeczko.app.logic.Film;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDatabaseConnector {
    @Test
    public void testValidConnection() {
        DatabaseConnector db = new DatabaseConnector();

        try {
            ArrayList<Film> films = db.getFilms();
            assertEquals("The Shawshank Redemption", films.get(0).getTitle());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
