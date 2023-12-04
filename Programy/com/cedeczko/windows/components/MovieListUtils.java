package com.cedeczko.windows.components;

import java.util.ArrayList;

public class MovieListUtils {
    public static ArrayList<String[]> getData() {
        var data = new ArrayList<String[]>();
        String[] genres = new String[]{"Action", "Horror", "Thriller", "Comedy"};
        //TODO: Remove when actual data can be used
        for (int i = 0; i < 200; i++) {
            data.add(new String[]{"a" + i, "b" + i, genres[i % 4], "c" + i});
        }
        return data;
    }
    public static String[] getFields() {
        return new String[]{"Tytuł", "Autor", "Gatunek", "Rok"};
    }
    public static ArrayList<String[]> limitTableData(String[] searchParams, ArrayList<String[]> data) {
        ArrayList<String[]> newData = new ArrayList<>();

        for(var row : data) {
            boolean addRow = true;
            for (int i = 0; i < searchParams.length; i++) {
                if (!row[i].contains(searchParams[i])) {
                    addRow = false;
                    break;
                }
            }
            if (addRow)
                newData.add(row);
        }

        return newData;
    }
}
