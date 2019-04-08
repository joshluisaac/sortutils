package com.sortutils;

import com.sortutils.entity.Distance;
import com.sortutils.entity.DistanceMap;
import com.sortutils.entity.DistanceUnitType;
import com.sortutils.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final String jsonText = "{\n" +
            "  \"distances\": [\n" +
            "    {\n" +
            "      \"key\": \"cm\",\n" +
            "      \"value\": 1.3\n" +
            "    },\n" +
            "    {\n" +
            "      \"key\": \"km\",\n" +
            "      \"value\": 1.3\n" +
            "    },\n" +
            "    {\n" +
            "      \"key\": \"mm\",\n" +
            "      \"value\": 1.3\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        DistanceMap<String,Number> d1 = new DistanceMap<>(DistanceUnitType.CM.getCode(),1.3);
        DistanceMap<String,Number> d2 = new DistanceMap<>(DistanceUnitType.KM.getCode(),-1.378);
        DistanceMap<String,Number> d3 = new DistanceMap<>(DistanceUnitType.MM.getCode(),1);
        List<DistanceMap> distances = new ArrayList<>();
        distances.add(d1);
        distances.add(d2);
        distances.add(d3);
        System.out.println(new JsonUtils().toJson(new Distance(distances)));

        Distance d = new JsonUtils().fromJson(jsonText,Distance.class);
        System.out.println(d.getDistances().toString());

    }


}
