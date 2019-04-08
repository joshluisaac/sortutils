package com.sortutils.entity;

public enum DistanceUnitType {

    CM("Centimeter","cm"),KM("Kilometer","km"),MM("Millimeter","mm"),M("Meters","m");

    private String description;
    private String code;

    DistanceUnitType(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
