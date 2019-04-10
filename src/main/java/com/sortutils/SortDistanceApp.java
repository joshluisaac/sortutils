package com.sortutils;

import com.sortutils.component.InsertionSort;
import com.sortutils.component.InstrumentationSort;
import com.sortutils.component.MergeSort;
import com.sortutils.entity.Distance;
import com.sortutils.entity.SortResponse;
import com.sortutils.parser.InputValidationParser;
import com.sortutils.util.DistanceUtils;
import com.sortutils.util.JsonUtils;
import com.sortutils.util.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SortDistanceApp {

    private static final Logger LOG = LoggerFactory.getLogger(SortDistanceApp.class);
    private final InstrumentationSort instrumentationSort;

    public SortDistanceApp(InstrumentationSort instrumentationSort) {
        this.instrumentationSort = instrumentationSort;
    }

    public SortResponse execute(double[] arr) {
        return instrumentationSort.execute(arr);
    }

    /**
     * Tuning parameter: list size at or below which insertion sort will be used in
     * preference to mergesort.
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;

    public static void main(String[] args) {

        String rawJsonString = args[0];

        /* Parse and validate input string */
        boolean isValidJson = InputValidationParser.isValidJson(rawJsonString);

        if (isValidJson) {
            MapperUtils mapperUtils = new MapperUtils();

            // deserialize raw json document to custom type
            Distance distance = mapperUtils.deserialize(rawJsonString);

            // map distance to list of same types.
            List<Double> distances = mapperUtils.map(distance);

            // remove duplicates
            List<Double> unique = new DistanceUtils().unique(distances);

            System.out.println("Raw list: " + rawJsonString);
            System.out.println("Unique list: " + unique.toString());

            // map distance to an array of doubles to facilitate comparison and sorting.
            // sorting performs best with array data structure.
            double[] arr = mapperUtils.toArray(unique);

            // sort response
            SortResponse response;

            if (arr.length < INSERTIONSORT_THRESHOLD) {
                response = new SortDistanceApp(new InsertionSort()).execute(arr);
            } else {
                response = new SortDistanceApp(new MergeSort()).execute(arr);
            }
            System.out.println("Sorted result: " + response.sortResult);
            System.out.println("Response payload: " + new JsonUtils().toJson(response));
        } else {
            LOG.error("{} is not a valid JSON formatted string.", rawJsonString);
        }

    }

}
