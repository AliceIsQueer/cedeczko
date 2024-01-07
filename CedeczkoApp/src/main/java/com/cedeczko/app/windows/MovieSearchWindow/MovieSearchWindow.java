package com.cedeczko.app.windows.MovieSearchWindow;

import com.cedeczko.app.logic.constants.WindowConstants;
import com.cedeczko.app.windows.MovieSearchWindow.components.MovieList;
import com.cedeczko.app.windows.MovieSearchWindow.components.MovieSearchBars;

import javax.swing.*;
import java.awt.*;

public class MovieSearchWindow {
    private JFrame frame;

    private MovieSearchBars movieSearchBars;
    private MovieList movieList;

    private JLabel loader;

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

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        ImageIcon icon = new ImageIcon("src/main/resources/loader.gif");
        loader = new JLabel(icon);
        loader.setPreferredSize(new Dimension(WindowConstants.width, 200));

        movieList = new MovieList(frame, loader);
        movieSearchBars = new MovieSearchBars(movieList);
        movieList.getPanel().setVisible(false);

        centerPanel.add(movieSearchBars.getPanel());
        centerPanel.add(loader);
        centerPanel.add(movieList.getPanel());

        frame.add(BorderLayout.CENTER, centerPanel);
        frame.setVisible(true);
    }


    public JFrame getFrame() {
        return frame;
    }
}
