package com.cedeczko.windows;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class MainWindowRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
        });
    }
}
