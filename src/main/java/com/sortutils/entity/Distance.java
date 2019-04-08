package com.sortutils.entity;

import java.util.List;

public class Distance {

    List<DistanceMap> distances;

    public Distance(List<DistanceMap> distances) {
        this.distances = distances;
    }

    public List<DistanceMap> getDistances() {
        return distances;
    }

    public void setDistances(List<DistanceMap> distances) {
        this.distances = distances;
    }

    @Override
    public String toString() {
        return "Distance{" + "distances=" + distances + '}';
    }
}
