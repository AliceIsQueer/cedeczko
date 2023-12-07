package com.cedeczko.app;

import com.cedeczko.app.windows.components.MovieListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class HelperClass {
    static public boolean areStringArraysSame(String[] first, String[] second) {
        if(first.length != second.length) return false;
        return IntStream.range(0, first.length).allMatch(i -> first[i].equals(second[i]));
    }
    static public boolean areArrayListsSame(ArrayList<String[]> first, ArrayList<String[]> second) {
        if(first.size() != second.size()) return false;
        return IntStream.range(0, first.size()).allMatch(i -> HelperClass.areStringArraysSame(first.get(i), second.get(i)));
    }
}
public class TestMovieListUtils {
    @Test
    public void testStandardInput() {
        String[] searchParams = {"a", "b", "c"};
        ArrayList<String[]> values = new ArrayList<>();
        values.add(new String[]{"aaab", "cccc", "cddc"});
        values.add(new String[]{"aaaab", "bbbbbc", "ccccd"});

        ArrayList<String[]> answer = new ArrayList<>();
        answer.add(new String[]{"aaaab", "bbbbbc", "ccccd"});

        ArrayList<String[]> filteredValues = MovieListUtils.limitTableData(searchParams, values);

        assertTrue(HelperClass.areArrayListsSame(filteredValues, answer));
    }
    @Test
    public void testEmptyFilter() {
        String[] searchParams = {"", "", ""};
        ArrayList<String[]> values = new ArrayList<>();
        values.add(new String[]{"aaab", "cccc", "cddc"});
        values.add(new String[]{"aaaab", "bbbbbc", "ccccd"});

        ArrayList<String[]> filteredValues = MovieListUtils.limitTableData(searchParams, values);

        assertTrue(HelperClass.areArrayListsSame(values, filteredValues));
    }
}
