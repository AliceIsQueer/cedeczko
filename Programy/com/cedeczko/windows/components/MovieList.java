package com.cedeczko.windows.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MovieList {

    JPanel panel;
    JTable movieTable;
    JScrollPane scrollPane;

    public MovieList() {
        panel = new JPanel();

        movieTable = createMoviePanel();
        scrollPane = createScrollPane();
//        scrollPane.add(movieTable);

        panel.add(BorderLayout.CENTER, scrollPane);
    }
    private JTable createMoviePanel() {
        String[] fields = {"Tytuł", "Autor", "Rok"};
        var data = new ArrayList<String[]>();
        //TODO: Remove when actual data can be used
        for (int i = 0; i < 200; i++) {
            data.add(new String[]{"a" + i, "b" + i, "c" + i});
        }
        var model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        movieTable = new JTable(model);

        for(var field: fields)
            model.addColumn(field);

        movieTable.getColumnModel().getColumn(0).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(1).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(2).setPreferredWidth(2 * 800 / 20);

        for(var row: data) {
            System.out.println(row[0] + " " + row[1] + " " + row[2]);
            model.addRow(row);
        }

//        movieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return movieTable;
    }
    private JScrollPane createScrollPane() {
        return new JScrollPane(movieTable);
    }
    public JPanel getPanel() {
        return panel;
    }
}
