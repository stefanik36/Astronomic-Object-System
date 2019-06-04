package com.agh.aos.model;

import com.agh.aos.util.ConstantValues;
import io.vavr.collection.List;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;
import org.junit.Test;

import javax.measure.VectorMeasure;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Velocity;

import java.util.Arrays;

import static javax.measure.unit.SI.*;
import static junit.framework.TestCase.assertEquals;

public class AstronomicalObjectTest {

    @Test
    public void construct() {
        AstronomicalObject astronomicalObject = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(100.0, METER),
                Amount.valueOf(100.0, KILOGRAM),
                XYZ.valueOf(2.0, 1.0, 0.0, METER),
                VectorMeasure.valueOf(1.0, 2.0, 3.0, METRES_PER_SECOND)
        );

        assertEquals(2.0, astronomicalObject.getPosition().xValue(METER),0.0001);
        assertEquals(1.0, astronomicalObject.getPosition().yValue(METER),0.0001);
        assertEquals(0.0, astronomicalObject.getPosition().zValue(METER),0.0001);
    }

    @Test
    public void move() {
        AstronomicalObject astronomicalObject = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(100.0, METER),
                Amount.valueOf(100.0, KILOGRAM),
                XYZ.valueOf(2.0, 1.0, 0.0, METER),
                VectorMeasure.valueOf(1.0, -2.0, 3.0, METRES_PER_SECOND)
        );

        astronomicalObject.move();
        assertEquals(3.0, astronomicalObject.getPosition().xValue(METER),0.0001);
        assertEquals(-1.0, astronomicalObject.getPosition().yValue(METER),0.0001);
        assertEquals(3.0, astronomicalObject.getPosition().zValue(METER),0.0001);
    }



    @Test
    public void computeAcceleration() {

        AstronomicalObject earth = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(0.0, KILOGRAM),
                XYZ.valueOf(4.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicalObject sun = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.SUN,
                "Sun",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(9.0, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        VectorMeasure<Acceleration> result = earth.computeAcceleration(
                earth,
                sun,
                Amount.valueOf(25.0, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );


        System.out.println(Arrays.toString(result.getValue()));
        assertEquals(-14.0625, result.getValue()[0], 0.001);
        assertEquals(0.0, result.getValue()[1]);
        assertEquals(0.0, result.getValue()[2]);

    }

    @Test
    public void computeAccelerationSum() {

        AstronomicalObject moved = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "moved",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(0.0, KILOGRAM),
                XYZ.valueOf(4.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicalObject moving01 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "moving01",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(9.0, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        AstronomicalObject moving02 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "moving02",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(2.10022, KILOGRAM),
                XYZ.valueOf(0.0, -5.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );


        AstronomicalObjectSystem astronomicalObjectSystem = new AstronomicalObjectSystem(
                List.of(moved, moving01, moving02),
                Amount.valueOf(25.0, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
        astronomicalObjectSystem.printPositions();


        VectorMeasure<Acceleration> result = moved.computeAccelerationSum(astronomicalObjectSystem);


        System.out.println(Arrays.toString(result.getValue()));
        assertEquals(-14.86249819071631, result.getValue()[0], 0.0001);
        assertEquals(-1.0, result.getValue()[1], 0.0001);
        assertEquals(0.0, result.getValue()[2], 0.0001);

    }

    @Test
    public void updateVelocity() {

        AstronomicalObject earth = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        earth.setAcceleration(VectorMeasure.valueOf(2.0, -1.0, 3.0, METERS_PER_SQUARE_SECOND));

        VectorMeasure<Velocity> result = earth.updateVelocity();

        System.out.println(Arrays.toString(result.getValue()));
        assertEquals(2.0, result.getValue()[0]);
        assertEquals(-1.0, result.getValue()[1]);
        assertEquals(3.0, result.getValue()[2]);
    }



}