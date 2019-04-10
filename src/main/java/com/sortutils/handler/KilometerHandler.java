package com.sortutils.handler;

import java.util.List;

public class KilometerHandler implements Handler {
	
	List<Double> maybeDuplicate;
	double value;
	int coefficient;
	
	public KilometerHandler() {}
	
	public KilometerHandler(List<Double> maybeDuplicate, double value, int coefficient) {
		this.maybeDuplicate = maybeDuplicate;
		this.value = value;
		this.coefficient = coefficient;
	}

    @Override
    public List<Double> apply(final List<Double> maybeDuplicate, double value, int coefficient) {
        double d = value * coefficient;
        maybeDuplicate.add(d);
        return maybeDuplicate;
    }
    
    @Override
    public List<Double> apply() {
        double d = value * coefficient;
        maybeDuplicate.add(d);
        return maybeDuplicate;
    }
}
