package com.cedeczko.app.logic.util;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public static ArrayList<String[]> limitTableData(SearchParams searchParams, ArrayList<String[]> data) {
        return (ArrayList<String[]>)data.stream()
                .filter(searchParams::listIncludesParams)
                .collect(Collectors.toList());
    }
}
