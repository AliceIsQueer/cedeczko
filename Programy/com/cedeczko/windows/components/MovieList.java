package com.cedeczko.windows.components;

import com.cedeczko.logic.util.Pair;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MovieList implements StateChangeListener {

    JPanel panel;
    DefaultTableModel tableModel;
    JTable movieTable;
    JScrollPane scrollPane;

    String[] searchParams;

    ArrayList<String[]> tableData;
    public MovieList() {
        panel = new JPanel();

        tableData = MovieListUtils.getData();
        this.searchParams = new String[]{"", "", "", ""};

        movieTable = createMoviePanel();
        scrollPane = createScrollPane();
//        scrollPane.add(movieTable);

        panel.add(BorderLayout.CENTER, scrollPane);
    }
    private JTable createMoviePanel() {

        tableModel = createTableModel();
        addDataToTable(tableData);

        movieTable = new JTable(tableModel);

        movieTable.getColumnModel().getColumn(0).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(1).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(2).setPreferredWidth(4 * 800 / 10);
        movieTable.getColumnModel().getColumn(3).setPreferredWidth(2 * 800 / 20);
//        movieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return movieTable;
    }

    private void limitTableData() {
        ArrayList<String[]> newTableData = MovieListUtils.limitTableData(searchParams, tableData);
        clearTable();
        addDataToTable(newTableData);
    }
    private void addDataToTable(ArrayList<String[]> tableData) {
        for(var row: tableData)
            tableModel.addRow(row);
    }
    private void clearTable() {
        while (tableModel.getRowCount() > 0)
            tableModel.removeRow(0);
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

    @Override
    public void onStateChange(Pair<Integer, String> newState) {
        int index = newState.getKey();
        String value = newState.getValue();
        searchParams[index] = value;

        limitTableData();

        for (int i = 0; i < searchParams.length; i++) {
            System.out.println(i + ": " + searchParams[i]);
        }
    }
}
