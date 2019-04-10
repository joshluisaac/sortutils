package com.sortutils.handler;

import java.util.List;

import com.sortutils.entity.DistanceMap;

public interface IDistanceHandlerFactory {

	Handler getHandler(DistanceMap distanceMap, List<Double> maybeDuplicate);

}