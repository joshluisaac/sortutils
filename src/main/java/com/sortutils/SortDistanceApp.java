package com.sortutils;

import com.sortutils.component.InsertionSort;
import com.sortutils.component.InstrumentationSort;
import com.sortutils.component.MergeSort;
import com.sortutils.entity.Distance;
import com.sortutils.entity.SortResponse;
import com.sortutils.parser.InputValidationParser;
import com.sortutils.util.JsonUtils;
import com.sortutils.util.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortDistanceApp {

    private static final Logger LOG = LoggerFactory.getLogger(SortDistanceApp.class);
    private final InstrumentationSort instrumentationSort;

    public SortDistanceApp(InstrumentationSort instrumentationSort){
        this.instrumentationSort = instrumentationSort;
    }

    public SortResponse execute(double[] arr){
        return instrumentationSort.execute(arr);
    }

    /**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort.
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;


    public static void main(String[] args) {

        String maybeJson = args[0];

        /* Parse and validate input string */
        boolean isValidJson = InputValidationParser.isValidJson(maybeJson);

        if (isValidJson){
            MapperUtils mapperUtils = new MapperUtils();

            //deserialize raw json document to custom type
            Distance distance = mapperUtils.deserialize(maybeJson);

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
        } else {
            LOG.error("{} is not a valid JSON formatted string.", maybeJson);
        }





    }

}
