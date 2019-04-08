package com.sortutils.entity;

import java.util.List;

/**
 * A POJO entity representing a distance model
 *
 *
 * @author Joshua Nwankwo
 * @version 1.0
 * @since April 2019
 */

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
