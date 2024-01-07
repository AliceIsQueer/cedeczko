package com.cedeczko.app;

import com.cedeczko.app.windows.BasketWindow;
import com.cedeczko.app.windows.LoaderWindow.LoaderWindow;
import com.cedeczko.app.windows.MainWindow;
import com.cedeczko.app.windows.MovieSearchWindow.MovieSearchWindow;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoaderWindow loaderWindow = new LoaderWindow();
            MovieSearchWindow movieSearchWindow = new MovieSearchWindow(loaderWindow);
//            MainWindow mainWindow = new MainWindow(basketWindow);
        });
    }
}
