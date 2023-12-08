package com.cedeczko.app.windows.MovieSearchWindow.components;

import com.cedeczko.app.logic.util.MovieListUtils;
import com.cedeczko.app.logic.util.Pair;
import com.cedeczko.app.logic.util.SearchParams;
import com.cedeczko.app.windows.ProductWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MovieList implements StateChangeListener {

    JPanel panel;
    DefaultTableModel tableModel;
    JTable movieTable;
    JScrollPane scrollPane;

    SearchParams searchParams;

    ArrayList<String[]> tableData;
    JFrame parentFrame;
    public MovieList(JFrame frame) {
        panel = new JPanel();

        tableData = MovieListUtils.getData();
        this.searchParams = new SearchParams(4);
        parentFrame = frame;

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

        movieTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2)
                    new ProductWindow(parentFrame);
            }
        });
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
        searchParams.set(index, value);

        limitTableData();
    }
}
