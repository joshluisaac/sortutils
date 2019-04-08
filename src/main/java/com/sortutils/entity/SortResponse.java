package com.sortutils.entity;

//A POJO object representing sort response details

/**
 * A POJO entity representing sort response details
 *
 *
 * @author Joshua Nwankwo
 * @version 1.0
 * @since April 2019
 */

public class SortResponse {

    //number of iterations to get this into sorted state
    public int count;
    public String sortResult;
    public String input;
    public String runningTime;
    public int arraySize;

    public SortResponse(int count, String sortResult,String runningTime,int arraySize) {
        this.count = count;
        this.sortResult = sortResult;
        this.runningTime = runningTime;
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSortResult() {
        return sortResult;
    }

    public void setSortResult(String sortResult) {
        this.sortResult = sortResult;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "SortResponse{" +
                "count=" + count +
                ", sortResult='" + sortResult + '\'' +
                ", input='" + input + '\'' +
                ", runningTime=" + runningTime +
                '}';
    }
}
