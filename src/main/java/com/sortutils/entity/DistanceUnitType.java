package com.sortutils.entity;

public enum DistanceUnitType {

    //added coefficient which is a multiplicative factor for each enum property

    MM("Millimeter","mm",1),
    CM("Centimeter","cm", 10),
    M("Meters","m",1000),
    KM("Kilometer","km",1000000);



    private String description;
    private String code;
    private int coefficient;

    DistanceUnitType(String description, String code, int coefficient) {
        this.description = description;
        this.code = code;
        this.coefficient = coefficient;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
