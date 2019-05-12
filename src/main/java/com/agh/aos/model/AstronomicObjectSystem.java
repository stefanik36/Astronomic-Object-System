package com.agh.aos.model;


import io.vavr.collection.List;

import static javax.measure.unit.SI.METER;

public class AstronomicObjectSystem {
    private List<AstronomicObject> astronomicObjectList;

    public AstronomicObjectSystem(List<AstronomicObject> astronomicObjectList) {
        this.astronomicObjectList = astronomicObjectList;
    }

    public void printPositions() {
        String posString = astronomicObjectList.map(
                ao -> ao.getName()
                        + "[" + ao.getPosition().xValue(METER)
                        + "," + ao.getPosition().yValue(METER)
                        + "," + ao.getPosition().zValue(METER) + "]"
        ).reduce((a, b) -> a +" | "+ b);
        System.out.println(posString);
    }

    public List<AstronomicObject> getAstronomicObjectList() {
        return astronomicObjectList;
    }

    public void setAstronomicObjectList(List<AstronomicObject> astronomicObjectList) {
        this.astronomicObjectList = astronomicObjectList;
    }
}
