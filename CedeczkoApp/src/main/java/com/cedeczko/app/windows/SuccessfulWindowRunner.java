package com.cedeczko.app.windows;

import javax.swing.SwingUtilities;

public class SuccessfulWindowRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SuccessfulWindow successful_window = new SuccessfulWindow();
            }
        });
    }
}