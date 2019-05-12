package com.agh.aos.model;

import com.agh.aos.model.AstronomicObject;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;
import org.junit.Test;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;
import static junit.framework.TestCase.assertEquals;

public class AstronomicObjectTest {

    @Test
    public void construct() {
        AstronomicObject astronomicObject = new AstronomicObject(
                "Earth",
                Amount.valueOf(100.0, METER),
                Amount.valueOf(100.0, KILOGRAM),
                XYZ.valueOf(2.0, 1.0, 0.0, METER),
                VectorMeasure.valueOf(1.0, 2.0, 3.0, METRES_PER_SECOND)
        );

        assertEquals(2.0, astronomicObject.getPosition().xValue(METER),0.0001);
        assertEquals(1.0, astronomicObject.getPosition().yValue(METER),0.0001);
        assertEquals(0.0, astronomicObject.getPosition().zValue(METER),0.0001);
    }

    @Test
    public void move() {
        AstronomicObject astronomicObject = new AstronomicObject(
                "Earth",
                Amount.valueOf(100.0, METER),
                Amount.valueOf(100.0, KILOGRAM),
                XYZ.valueOf(2.0, 1.0, 0.0, METER),
                VectorMeasure.valueOf(1.0, -2.0, 3.0, METRES_PER_SECOND)
        );

        astronomicObject.move();
        assertEquals(3.0, astronomicObject.getPosition().xValue(METER),0.0001);
        assertEquals(-1.0, astronomicObject.getPosition().yValue(METER),0.0001);
        assertEquals(3.0, astronomicObject.getPosition().zValue(METER),0.0001);
    }


}