package com.sortutils.handler;

import java.util.List;

public class MeterHandler implements Handler {

    @Override
    public List<Double> apply(final List<Double> maybeDuplicate, double value, int coefficient) {
        double d = value * coefficient;
        maybeDuplicate.add(d);
        return maybeDuplicate;
    }

}
