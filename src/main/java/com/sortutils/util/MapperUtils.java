package com.sortutils.util;

import com.sortutils.entity.Distance;
import com.sortutils.entity.DistanceMap;
import com.sortutils.entity.DistanceUnitType;

import java.util.List;

public class MapperUtils {


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
     * @return array of primitive type double.
     */
    public double[] map(Distance distance){
        int size = distance.getDistances().size();
        double[] arr = new double[size];
        List<DistanceMap> list = distance.getDistances();
        System.out.println(list.get(0));
        for (int i = 0; i < size; i++) {
            DistanceMap distanceMap =  list.get(i);
            if (distanceMap.key.equals(DistanceUnitType.KM.getCode())) {
                double d = Double.parseDouble(distanceMap.getValue().toString()) * 1000000;
                arr[i] = d;
            }
            if (distanceMap.key.equals(DistanceUnitType.M.getCode())) {
                double d = Double.parseDouble(distanceMap.getValue().toString()) * 1000;
                arr[i] = d;
            }
            if (distanceMap.key.equals(DistanceUnitType.CM.getCode())) {
                double d = Double.parseDouble(distanceMap.getValue().toString()) * 10;
                arr[i] = d;
            }
            if (distanceMap.key.equals(DistanceUnitType.MM.getCode())) {
                double d = Double.parseDouble(distanceMap.getValue().toString()) * 1;
                arr[i] = d;
            }
        }
        return  arr;
    }




}
