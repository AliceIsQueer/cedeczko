package com.cedeczko.windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
        private JFrame frame;

        private MovieSearchWindow movieSearchWindow;


        public MainWindow() {
            initializeFrames();
            initializeWindow();
        }

    private void initializeWindow() {
        frame = new JFrame();
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

//        addFrames();
    }

    private void initializeFrames() {
        movieSearchWindow = new MovieSearchWindow();
    }

    private void addFrames() {
//            frame.add(BorderLayout.NORTH, movieSearchWindow.getFrame());
    }
}
