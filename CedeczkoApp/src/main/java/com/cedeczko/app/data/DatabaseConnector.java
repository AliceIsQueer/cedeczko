package com.cedeczko.app.data;

import com.cedeczko.app.logic.Film;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector implements Database {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    String url;

    public DatabaseConnector() {
        this.url = "jdbc:mysql://alicja.ampio.com:3306/cedeczko?"
                 + "user=app&password=cedeczko2425";
    }

    public DatabaseConnector(String url) {
        this.url = url;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Film> getFilms() throws SQLException {
        ArrayList<Film> films = new ArrayList<>();
        try {
            connect = DriverManager
                    .getConnection(url);

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from cedeczko.movies where sold=false");

            while (resultSet.next()) {
                int movie_id = resultSet.getInt("movie_id");
                String title = resultSet.getString("title");
                int director_id = resultSet.getInt("director_id");
                int price = resultSet.getInt("price");
                int year = resultSet.getInt("release_year");
                String description = resultSet.getString("description");
                ArrayList<String> genres = getFilmGenres(movie_id);
                String director_name = getDirectorName(director_id);
                Blob poster = resultSet.getBlob("poster");

                Film film = new Film(title, director_name, year, price, genres, description, poster);

                films.add(film);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            close();
        }
        return films;
    }

    private ArrayList<String> getFilmGenres(int movie_id) {
        try {
            Connection connect = DriverManager
                    .getConnection(url);

            Statement statement = connect.createStatement();
            String query = "SELECT g.name FROM cedeczko.movies m\n" +
                           "INNER JOIN cedeczko.movies_genres mg ON (mg.movie_id = m.movie_id)\n" +
                           "INNER JOIN cedeczko.genres g ON (g.genre_id = mg.genre_id)\n" +
                           "WHERE m.movie_id = " + movie_id + ";";

            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<String> genres = new ArrayList<>();

            while(resultSet.next()) {
                String genre = resultSet.getString("name");
                genres.add(genre);
            }

            return genres;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private String getDirectorName(int director_id) {
        try {
            Connection connect = DriverManager
                    .getConnection(url);

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, surname FROM cedeczko.directors WHERE director_id = " + director_id + ";");

            resultSet.next();
            return resultSet.getString("name") + " "+ resultSet.getString("surname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<String> getGenres() throws SQLException {
        ArrayList<String> genres = new ArrayList<>();
        try {
            connect = DriverManager
                            .getConnection(url);

            statement = connect.createStatement();
            resultSet = statement.executeQuery("select name from cedeczko.genres");

            while(resultSet.next())
                genres.add(resultSet.getString("name"));
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            close();
        }

        return genres;
    }

    public void deleteFilm(String[] filmInformation) {
        try {
            connect = DriverManager
                            .getConnection(url);
            PreparedStatement preparedStatement1 = connect.prepareStatement("select * from cedeczko.movies where description = ?;");
            preparedStatement1.setString(1, filmInformation[5]);
            resultSet = preparedStatement1.executeQuery();
            int id = -1;
            String title = null;
            String director = null;
            if (resultSet.next()) {
              id = resultSet.getInt("movie_id");
              title = resultSet.getString("title");
              int director_id = resultSet.getInt("director_id");
              director = getDirectorName(director_id);
            }

            PreparedStatement preparedStatement2 = connect.prepareStatement("update cedeczko.movies set sold=true where movie_id = ?;");
            preparedStatement2.setInt(1, id);
            preparedStatement2.executeUpdate();

            /*PreparedStatement preparedStatement3 = connect.prepareStatement("delete from cedeczko.movies_genres where movie_id = ?;");
            preparedStatement3.setInt(1, id);
            preparedStatement3.executeUpdate();*/

            String filmId = title.toLowerCase().replace(" ", "") + "_" + director.toLowerCase().replace(" ", "");
            MovieCache.removeFilm(filmId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }
}
