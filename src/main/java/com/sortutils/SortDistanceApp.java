package com.sortutils;

import com.sortutils.component.InsertionSort;
import com.sortutils.component.MergeSort;
import com.sortutils.entity.Distance;
import com.sortutils.util.JsonUtils;
import com.sortutils.util.MapperUtils;

public class SortDistanceApp {


    public static final String jsonText = "{\n" +
            "  \"distances\": [\n" +
            "    {\n" +
            "      \"key\": \"cm\",\n" +
            "      \"value\": 1.367\n" +
            "    },\n" +
            "    {\n" +
            "      \"key\": \"km\",\n" +
            "      \"value\": -1.37\n" +
            "    },\n" +
            "    {\n" +
            "      \"key\": \"mm\",\n" +
            "      \"value\": 1\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {

        MapperUtils mapperUtils = new MapperUtils();
        Distance distance = mapperUtils.deserialize(jsonText);
        double[] arr = mapperUtils.map(distance);

        InsertionSort ins = new InsertionSort();
        MergeSort mergeSort = new MergeSort();


        System.out.println(new JsonUtils().toJson(mergeSort.execute(arr)));


    }

}
