package com.cedeczko.windows.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MovieSearchBars {
    private JPanel panel;
    private JTextField movieNameTextField;
    private JTextField movieAuthorTextField;
    private JComboBox<String> movieGenrePicker;
    private JTextField movieYearTextField;

    public MovieSearchBars() {
        panel = new JPanel();

        movieNameTextField = createNameTextField();
        movieAuthorTextField = createAuthorTextField();
        movieGenrePicker = createMovieGenrePicker();
        movieYearTextField = createYearTextField();

        panel.add(BorderLayout.NORTH, movieNameTextField);
        panel.add(BorderLayout.NORTH, movieAuthorTextField);
        panel.add(BorderLayout.NORTH, movieGenrePicker);
        panel.add(BorderLayout.NORTH, movieYearTextField);
    }

    private JTextField createYearTextField() {
        return new SearchBox("Rok...", "Wyszukaj film po roku wydania", 4);
    }

    private JTextField createNameTextField() {
        return new SearchBox("Tytuł...", "Wyszukaj film po tytule", 15);
    }
    private JTextField createAuthorTextField() {
        return new SearchBox("Autor...", "Wyszukaj film po autorze", 15);
    }
    private JComboBox<String> createMovieGenrePicker() {
        String[] genres = {"Action", "Horror", "Thriller", "Comedy"};
        JComboBox<String> moviePicker = new JComboBox<>(genres);
        moviePicker.setSelectedIndex(-1);
        moviePicker.addActionListener(e -> System.out.println(moviePicker.getSelectedItem()));
        return moviePicker;
    }

    public JPanel getPanel() {
        return panel;
    }
}
