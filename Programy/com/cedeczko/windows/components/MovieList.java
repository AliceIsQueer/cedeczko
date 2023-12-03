package com.cedeczko.windows.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MovieList {

    JPanel panel;
    DefaultTableModel tableModel;
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
        ArrayList<String[]> data = MovieListUtils.getData();

        tableModel = createTableModel();
        addDataToTable(data);

        movieTable = new JTable(tableModel);

        movieTable.getColumnModel().getColumn(0).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(1).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(2).setPreferredWidth(2 * 800 / 20);
//        movieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return movieTable;
    }

    private void addDataToTable(ArrayList<String[]> data) {
        for(var row: data)
            tableModel.addRow(row);
    }
    private DefaultTableModel createTableModel() {
        String[] fields = MovieListUtils.getFields();
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        for(var field: fields)
            tableModel.addColumn(field);

        return tableModel;

    }
    private JScrollPane createScrollPane() {
        return new JScrollPane(movieTable);
    }
    public JPanel getPanel() {
        return panel;
    }
}
