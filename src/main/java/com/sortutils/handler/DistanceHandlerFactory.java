package com.sortutils.handler;

import com.sortutils.entity.DistanceMap;
import com.sortutils.entity.DistanceUnitType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DistanceHandlerFactory {

    private DistanceHandlerFactory(){}

    private static final Logger LOG = LoggerFactory.getLogger(DistanceHandlerFactory.class);

    public static void applyHandler (DistanceMap distanceMap, List<Double> maybeDuplicate){
        String key = (String) distanceMap.getKey();
        double value = Double.parseDouble(distanceMap.getValue().toString());

        if (key.equalsIgnoreCase(DistanceUnitType.KM.getCode())) {
            new KilometerHandler().apply(maybeDuplicate,value,DistanceUnitType.KM.getCoefficient());
        }
        else if (key.equalsIgnoreCase(DistanceUnitType.M.getCode())) {
            new MeterHandler().apply(maybeDuplicate,value,DistanceUnitType.M.getCoefficient());
        }
        else if (key.equalsIgnoreCase(DistanceUnitType.CM.getCode())) {
            new CentimeterHandler().apply(maybeDuplicate,value,DistanceUnitType.CM.getCoefficient());
        }
        else if (key.equalsIgnoreCase(DistanceUnitType.MM.getCode())) {
            new MillimeterHandler().apply(maybeDuplicate,value,DistanceUnitType.MM.getCoefficient());
        }
        else {
            LOG.error("{} is not a valid DistanceUnitType", key);
            throw new IllegalArgumentException("The argument specified is not a valid DistanceUnitType");
        }
    }



}
