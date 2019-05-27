package com.agh.aos.model;


import io.vavr.collection.List;
import org.jscience.physics.amount.Amount;

import javax.measure.quantity.Mass;
import javax.measure.quantity.Quantity;

import static javax.measure.unit.SI.METER;

public class AstronomicObjectSystem {
    private List<AstronomicObject> astronomicObjectList;
    private Amount<?> gravitationalConstant;
    private long epoch;
    private double stepSize;

    public AstronomicObjectSystem(List<AstronomicObject> astronomicObjectList, Amount<?> gravitationalConstant) {
        this.astronomicObjectList = astronomicObjectList;
        this.gravitationalConstant = gravitationalConstant;
        this.epoch = 0;
        this.stepSize = 1.0;
    }

    public void printPositions() {
        String posString = "[" + epoch + "] " + astronomicObjectList.map(
                ao -> ao.getName()
                        + "[" + ao.getPosition().xValue(METER)
                        + "," + ao.getPosition().yValue(METER)
                        + "," + ao.getPosition().zValue(METER) + "]"
        ).reduce((a, b) -> a + " | " + b);
        System.out.println(posString);
    }

    public List<AstronomicObject> getAstronomicObjectList() {
        return astronomicObjectList;
    }

    public void setAstronomicObjectList(List<AstronomicObject> astronomicObjectList) {
        this.astronomicObjectList = astronomicObjectList;
    }

    public Amount<?> getGravitationalConstant() {
        return gravitationalConstant;
    }

    public void setGravitationalConstant(Amount<?> gravitationalConstant) {
        this.gravitationalConstant = gravitationalConstant;
    }

    public void nextStep() {
        this.astronomicObjectList.toJavaParallelStream().forEach(ao ->
                ao.computeAccelerationSum(this)
        );
        this.astronomicObjectList.toJavaParallelStream().forEach(ao -> {
                    ao.updateVelocity();
                    ao.move();
                }
        );
        epoch++;
//        this.printPositions();
    }

    public double getStepSize() {
        return stepSize;
    }

    public AstronomicObjectSystem setStepSize(double stepSize) {
        this.stepSize = stepSize;
        astronomicObjectList.forEach(ao -> ao.setStepSize(this.stepSize));
        return this;
    }
}
