package com.sortutils.entity;

import java.util.List;

public class Distance {

    List<? extends Number> distances;

    public Distance(List<? extends Number> distances) {
        this.distances = distances;
    }

    public List<? extends Number> getDistances() {
        return distances;
    }

    public void setDistances(List<? extends Number> distances) {
        this.distances = distances;
    }



}
