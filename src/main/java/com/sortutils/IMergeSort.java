package com.sortutils;

public interface IMergeSort extends InstrumentationSort {

    public int calculateMidPoint(double[] arr);
    abstract double[] constructRightArray(int midPoint, double[] arr);
    public double[] loadRightArray(double[] right, double[] arr);
    public double[] loadLeftArray(int midPoint, double[] left, double[] arr);
    public double[] merge(double[] leftArr, double[] rightArr);

}
