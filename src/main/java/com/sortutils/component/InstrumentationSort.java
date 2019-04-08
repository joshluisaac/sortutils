package com.sortutils.component;

import com.sortutils.entity.SortResponse;

public interface InstrumentationSort {

    double[]  sort(double[] arr);
    public SortResponse execute(double[] arr);
}
