package com.sortutils;

import java.util.List;

public class MapperUtils {


    /**
     * Deserializes the raw JSON input request string to specific/custom type.
     * @param jsonText
     * @return {@link Distance} type
     */
    public Distance deserialize(String jsonText){
        return new JsonUtils().fromJson(jsonText,Distance.class);
    }

    /**
     * Maps a {@link Distance} to an array doubles which are of the same type
     * @param distance
     * @return array of primitive type double.
     */
    public double[] map(Distance distance){
        int size = distance.getDistances().size();
        double[] arr = new double[size];
        List<?> list = distance.getDistances();
        for (int i = 0; i < size; i++) {
            arr[i] = Double.parseDouble(list.get(i).toString());
        }
        return  arr;
    }




}
