package com.cedeczko.windows;

import com.cedeczko.windows.components.MovieList;
import com.cedeczko.windows.components.MovieSearchBars;

import javax.swing.*;
import java.awt.*;

public class MovieSearchWindow {
    private JPanel panel;

    private MovieSearchBars movieSearchBars;
    private MovieList movieList;

    public MovieSearchWindow() {
        panel = new JPanel();
//        panel.setLayout(new GridLayout(2, 1));

        movieList = new MovieList();
        movieSearchBars = new MovieSearchBars();

        panel.add(movieSearchBars.getPanel());
        panel.add(movieList.getPanel());
    }


    public JPanel getPanel() {
        return panel;
    }

}
