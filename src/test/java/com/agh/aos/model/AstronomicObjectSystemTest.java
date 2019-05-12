package com.agh.aos.model;

import io.vavr.collection.List;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;
import org.junit.Test;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;
import static junit.framework.TestCase.assertEquals;

public class AstronomicObjectSystemTest {
    @Test
    public void construct() {
        double earthRadius = 6.371e+06;
        double earthMass = 5.972e+24;
        double earthX = -1.47095e+11;

        double sunRadius = 6.957e+08;
        double sunMass = 1.989e+30;


        AstronomicObject earth = new AstronomicObject(
                "Earth",
                Amount.valueOf(earthRadius, METER),
                Amount.valueOf(earthMass, KILOGRAM),
                XYZ.valueOf(earthX, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicObject sun = new AstronomicObject(
                "Sun",
                Amount.valueOf(sunRadius, METER),
                Amount.valueOf(sunMass, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicObjectSystem astronomicObjectSystem = new AstronomicObjectSystem(
                List.of(earth, sun)
        );
        astronomicObjectSystem.printPositions();
        assertEquals(astronomicObjectSystem.getAstronomicObjectList().size(), 2);

    }

}