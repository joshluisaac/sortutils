package com.sortutils.util;

import java.util.ArrayList;
import java.util.List;

public class DistanceUtils {

    /**
     * Takes a list of T and removes duplicate elements in that list
     *
     * @param list list of items
     * @return unique list of the specified type
     */
    public static <T> List<T> unique(List<T> list) {
        List<T> tmp = new ArrayList<>();
        for (T x : list) {
            if (!tmp.contains(x)) {
                tmp.add(x);
            }
        }
        return tmp;
    }

}
