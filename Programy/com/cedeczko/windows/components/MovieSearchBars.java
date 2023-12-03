package com.cedeczko.windows.components;

import javax.swing.*;
import java.awt.*;

public class MovieSearchBars {
    private JPanel panel;
    private JTextField movieNameTextField;
    private JTextField authorNameTextField;
    private JComboBox<String> movieGenrePicker;

    public MovieSearchBars() {
        panel = new JPanel();

        movieNameTextField = createMovieTextField();
        authorNameTextField = createAuthorTextField();
        movieGenrePicker = createMovieGenrePicker();

        panel.add(BorderLayout.NORTH, movieNameTextField);
        panel.add(BorderLayout.NORTH, authorNameTextField);
        panel.add(BorderLayout.NORTH, movieGenrePicker);
    }

    private JTextField createMovieTextField() {
        JTextField textField = new JTextField(15);

        textField.setToolTipText("Wyszukaj film po nazwie");
        textField.addActionListener(e -> System.out.println(textField.getText()));

        return textField;
    }
    private JTextField createAuthorTextField() {
        JTextField textField = new JTextField(15);

        textField.setToolTipText("Wyszukaj film po autorze");
        textField.addActionListener(e -> System.out.println(textField.getText()));

        return textField;
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
