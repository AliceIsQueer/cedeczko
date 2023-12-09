package com.cedeczko.app.windows.MovieSearchWindow.components;

import javax.swing.*;
import java.awt.*;

import com.cedeczko.app.logic.util.Pair;

public class MovieSearchBars {
    private JPanel panel;
    private JTextField movieNameTextField;
    private JTextField movieAuthorTextField;
    private JComboBox<String> movieGenrePicker;
    private JTextField movieYearTextField;
    private ExtraSearchArgs extraSearchArgs;
    private StateChangeListener listener;

    public MovieSearchBars(StateChangeListener listener) {
        this.listener = listener;
        panel = new JPanel();

        movieNameTextField = createNameTextField();
        movieAuthorTextField = createAuthorTextField();
        movieGenrePicker = createMovieGenrePicker();
        movieYearTextField = createYearTextField();
        extraSearchArgs = createExtraSearchArgs();

        panel.add(BorderLayout.NORTH, movieNameTextField);
        panel.add(BorderLayout.NORTH, movieAuthorTextField);
        panel.add(BorderLayout.NORTH, movieGenrePicker);
        panel.add(BorderLayout.NORTH, movieYearTextField);
        panel.add(BorderLayout.NORTH, extraSearchArgs);
    }


    private JTextField createNameTextField() {
        return new SearchBox("Tytuł...", "Wyszukaj film po tytule", 15, listener, 0);
    }
    private JTextField createAuthorTextField() {
        return new SearchBox("Reżyser...", "Wyszukaj film po autorze", 15, listener, 1);

    }
    private JComboBox<String> createMovieGenrePicker() {
        return new OptionPicker(new String[]{"Action", "Horror", "Thriller", "Comedy"}, listener, 2);

    }
    private JTextField createYearTextField() {
        return new SearchBox("Rok...", "Wyszukaj film po roku wydania", 4, listener, 3);
    }
    private ExtraSearchArgs createExtraSearchArgs() {
        return new ExtraSearchArgs();
    }

    public JPanel getPanel() {
        return panel;
    }
}
