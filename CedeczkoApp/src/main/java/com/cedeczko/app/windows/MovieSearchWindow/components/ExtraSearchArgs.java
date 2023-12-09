package com.cedeczko.app.windows.MovieSearchWindow.components;

import javax.swing.*;
import java.awt.*;
public class ExtraSearchArgs extends JButton {
    private ImageIcon icon;

    public ExtraSearchArgs() {
        icon = new ImageIcon("src/main/resources/settings.png");

        setIcon(icon);
    }
}
