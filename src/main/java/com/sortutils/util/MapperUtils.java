package com.sortutils.util;


import com.sortutils.entity.Distance;
import com.sortutils.entity.DistanceMap;
import com.sortutils.entity.DistanceUnitType;
import com.sortutils.handler.DistanceHandlerFactory;
import com.sortutils.handler.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MapperUtils {

    private static final Logger LOG = LoggerFactory.getLogger(MapperUtils.class);

    /**
     * Deserializes the raw JSON input request string to specific/custom type.
     * @param jsonText the raw json input
     * @return {@link Distance} type
     */
    public Distance deserialize(String jsonText){
        return new JsonUtils().fromJson(jsonText, Distance.class);
    }

    /**
     * Maps a {@link Distance} to an array doubles which are of the same type
     * @param distance
     * @return list of doubles.
     */
    public List<Double> map(Distance distance){
        final int size = distance.getDistances().size();
        final List<DistanceMap> list = distance.getDistances();
        final List<Double> maybeDuplicate = new ArrayList<>();
        for (int i = 0; i < size; i++) {
        	Handler handler = new DistanceHandlerFactory().getHandler(list.get(i),maybeDuplicate);
        	handler.apply();
        }
        return  maybeDuplicate;
    }


    /**
     * Maps a unique list of {@link Double} to an array of doubles
     * @param unique unique list
     * @return array of primitive type double.
     */
    public double[] toArray(List<Double> unique){
        int size = unique.size();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = unique.get(i);
        }
        return  arr;
    }











}
