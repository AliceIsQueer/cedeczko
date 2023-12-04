package com.cedeczko.windows;

import com.cedeczko.logic.constants.WindowConstants;
import com.cedeczko.windows.components.MovieList;
import com.cedeczko.windows.components.MovieSearchBars;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MovieSearchWindow {
    private JFrame frame;

    private MovieSearchBars movieSearchBars;
    private MovieList movieList;
    public MovieSearchWindow() {
        frame = new JFrame();
//        panel.setLayout(new GridLayout(2, 1));

        frame.setTitle("Cedeczko");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WindowConstants.width, WindowConstants.height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        movieList = new MovieList(frame);
        movieSearchBars = new MovieSearchBars(movieList);

        frame.add(BorderLayout.NORTH, movieSearchBars.getPanel());
        frame.add(BorderLayout.CENTER, movieList.getPanel());
    }


    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovieSearchWindow window = new MovieSearchWindow();
        });
    }

}
