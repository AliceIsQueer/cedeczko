package com.cedeczko.windows.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SearchBox extends JTextField {
    public SearchBox(String defaultText, String tooltip, int columns) {
        setColumns(columns);
        setText(defaultText);
        setForeground(Color.LIGHT_GRAY);

        setToolTipText(tooltip);
        addActionListener(e -> System.out.println(getText()));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setText("");
                setForeground(Color.BLACK);
            }
            @Override
            public void focusLost(FocusEvent e) {
                //nothing
            }
        });
    }
}
