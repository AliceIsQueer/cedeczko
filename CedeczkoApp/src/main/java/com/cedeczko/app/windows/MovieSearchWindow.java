package com.cedeczko.app.windows;

import com.cedeczko.app.logic.constants.WindowConstants;
import com.cedeczko.app.windows.components.MovieList;
import com.cedeczko.app.windows.components.MovieSearchBars;

import javax.swing.*;
import java.awt.*;

public class MovieSearchWindow {
    private JFrame frame;

    private MovieSearchBars movieSearchBars;
    private MovieList movieList;

    public MovieSearchWindow() {
        initialize();
    }
    public MovieSearchWindow(JFrame previousWindow) {
        initialize();
        previousWindow.dispose();
    }

    private void initialize() {
        frame = new JFrame();
//        panel.setLayout(new GridLayout(2, 1));

        frame.setTitle("Cedeczko");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WindowConstants.width, WindowConstants.height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        movieList = new MovieList(frame);
        movieSearchBars = new MovieSearchBars(movieList);


        centerPanel.add(movieSearchBars.getPanel());
        centerPanel.add(movieList.getPanel());

        frame.add(BorderLayout.CENTER, centerPanel);
    }


    public JFrame getFrame() {
        return frame;
    }
}
