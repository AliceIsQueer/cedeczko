package com.cedeczko.windows.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        return (ArrayList<String[]>)data.stream()
                .filter(row -> IntStream.range(0, row.length).allMatch(i -> row[i].contains(searchParams[i])))
                .collect(Collectors.toList());
    }
}
