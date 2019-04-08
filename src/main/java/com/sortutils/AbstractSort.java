package com.sortutils;

import java.util.Arrays;

public abstract class AbstractSort implements InstrumentationSort {

    //number of iterations to get data into a sorted state.
    public int count = -1;

    public SortResponse execute(double[] arr){
        final long startTime = System.currentTimeMillis();
        final double[] result = sort(arr);
        final long endTime = System.currentTimeMillis();
        final long runningTime = endTime - startTime;
        return new SortResponse(count, Arrays.toString(result),runningTime+" ms",arr.length);
    }

}
