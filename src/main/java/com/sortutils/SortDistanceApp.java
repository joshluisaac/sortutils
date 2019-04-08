package com.sortutils;

import com.sortutils.component.InsertionSort;
import com.sortutils.component.InstrumentationSort;
import com.sortutils.component.MergeSort;
import com.sortutils.entity.Distance;
import com.sortutils.entity.SortResponse;
import com.sortutils.util.JsonUtils;
import com.sortutils.util.MapperUtils;

import java.util.Collections;

public class SortDistanceApp {

    public InstrumentationSort instrumentationSort;

    public SortDistanceApp(InstrumentationSort instrumentationSort){
        this.instrumentationSort = instrumentationSort;
    }

    public SortResponse execute(double[] arr){
        return instrumentationSort.execute(arr);
    }

    /**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort.
     * To be removed in a future release.
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;


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

        //deserialize raw json document to custom type
        Distance distance = mapperUtils.deserialize(jsonText);

        //map distance to same types to facilitate comparison
        double[] arr = mapperUtils.map(distance);

        //sort response
        SortResponse response;

        if(arr.length < INSERTIONSORT_THRESHOLD) {
            response =  new SortDistanceApp(new InsertionSort()).execute(arr);
        } else {
            response =  new SortDistanceApp(new MergeSort()).execute(arr);
        }

        System.out.println(new JsonUtils().toJson(response));


    }

}
