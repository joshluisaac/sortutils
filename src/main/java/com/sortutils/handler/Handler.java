package com.sortutils.handler;

import java.util.List;

public interface Handler {

    public List<Double> apply(final List<Double> maybeDuplicate, double value, int coefficient);


}
