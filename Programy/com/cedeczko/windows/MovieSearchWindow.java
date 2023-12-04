package com.cedeczko.windows;

import com.cedeczko.windows.components.MovieList;
import com.cedeczko.windows.components.MovieSearchBars;
import com.cedeczko.windows.components.StateChangeListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieSearchWindow {
    private JPanel panel;

    private MovieSearchBars movieSearchBars;
    private MovieList movieList;
    public MovieSearchWindow() {
        panel = new JPanel();
//        panel.setLayout(new GridLayout(2, 1));

        movieList = new MovieList();
        movieSearchBars = new MovieSearchBars(movieList);

        panel.add(movieSearchBars.getPanel());
        panel.add(movieList.getPanel());
    }


    public JPanel getPanel() {
        return panel;
    }

}
