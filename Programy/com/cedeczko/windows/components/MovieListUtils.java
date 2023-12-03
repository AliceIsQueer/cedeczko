package com.cedeczko.windows.components;

import java.util.ArrayList;

public class MovieListUtils {
    public static ArrayList<String[]> getData() {
        var data = new ArrayList<String[]>();
        //TODO: Remove when actual data can be used
        for (int i = 0; i < 200; i++) {
            data.add(new String[]{"a" + i, "b" + i, "c" + i});
        }
        return data;
    }
    public static String[] getFields() {
        return new String[]{"Tytuł", "Autor", "Rok"};
    }
}
