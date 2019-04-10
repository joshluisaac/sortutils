package com.sortutils.handler;

import com.sortutils.entity.DistanceMap;
import com.sortutils.entity.DistanceUnitType;
import com.sortutils.exception.InvalidDistanceUnitTypeException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DistanceHandlerFactory implements IDistanceHandlerFactory {

    private static final Logger LOG = LoggerFactory.getLogger(DistanceHandlerFactory.class);

    Handler handler;

    /* (non-Javadoc)
	 * @see com.sortutils.handler.IDistanceHandlerFactory#getHandler(com.sortutils.entity.DistanceMap, java.util.List)
	 */
    @Override
	public Handler getHandler(DistanceMap distanceMap, List<Double> maybeDuplicate) {
        String key = (String) distanceMap.getKey();
        double value = Double.parseDouble(distanceMap.getValue().toString());

        if (key.equalsIgnoreCase(DistanceUnitType.KM.getCode())) {
            handler = new KilometerHandler(maybeDuplicate,value,DistanceUnitType.KM.getCoefficient());
        } else if (key.equalsIgnoreCase(DistanceUnitType.M.getCode())) {
            handler = new MeterHandler(maybeDuplicate,value,DistanceUnitType.M.getCoefficient());
        } else if (key.equalsIgnoreCase(DistanceUnitType.CM.getCode())) {
        	handler = new CentimeterHandler(maybeDuplicate,value,DistanceUnitType.CM.getCoefficient());
        } else if (key.equalsIgnoreCase(DistanceUnitType.MM.getCode())) {
        	handler = new MillimeterHandler(maybeDuplicate, value,DistanceUnitType.MM.getCoefficient());
        } else {
            LOG.error("{} is not a valid DistanceUnitType", key);
            throw new InvalidDistanceUnitTypeException("The argument specified is not a valid DistanceUnitType");
        }
        return handler;
    }

}
