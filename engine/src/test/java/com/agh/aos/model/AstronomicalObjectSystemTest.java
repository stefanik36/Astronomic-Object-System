package com.agh.aos.model;

import com.agh.aos.factory.AstronomicalObjectFactory;
import com.agh.aos.util.ConstantValues;
import io.vavr.collection.List;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;
import org.junit.Test;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;
import static junit.framework.TestCase.assertEquals;

public class AstronomicalObjectSystemTest {
    @Test
    public void construct() {

        AstronomicalObject earth = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicalObject sun = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.SUN,
                "Sun",
                Amount.valueOf(ConstantValues.SUN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SUN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        AstronomicalObjectSystem astronomicalObjectSystem = new AstronomicalObjectSystem(
                List.of(earth, sun),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
        astronomicalObjectSystem.printPositions();
        assertEquals(astronomicalObjectSystem.getAstronomicObjectList().size(), 2);

    }

    @Test
    public void moveOneObject() {

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

        moved.computeAccelerationSum(astronomicalObjectSystem);
        moved.updateVelocity();
        moved.move();

        astronomicalObjectSystem.printPositions();

        assertEquals(-10.86249819071631, moved.getPosition().xValue(METER), 0.0001);
        assertEquals(-1.0, moved.getPosition().yValue(METER), 0.0001);
        assertEquals(0.0, moved.getPosition().zValue(METER), 0.0001);

    }


    @Test
    public void moveAll() {

        AstronomicalObject ao01 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao01",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(0.0, KILOGRAM),
                XYZ.valueOf(4.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicalObject ao02 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao02",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(9.0, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        AstronomicalObject ao03 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao03",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(16, KILOGRAM),
                XYZ.valueOf(0.0, -5.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );


        AstronomicalObjectSystem astronomicalObjectSystem = new AstronomicalObjectSystem(
                List.of(ao01, ao02, ao03),
                Amount.valueOf(25.0, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
        astronomicalObjectSystem.printPositions();
        astronomicalObjectSystem.nextStep();

        astronomicalObjectSystem.printPositions();

        assertEquals(-16.15708582979926, ao01.getPosition().xValue(METER), 0.0001);
        assertEquals(-7.618232287249078, ao01.getPosition().yValue(METER), 0.0001);
        assertEquals(0.0, ao01.getPosition().zValue(METER), 0.0001);

        assertEquals(0.0, ao02.getPosition().xValue(METER), 0.0001);
        assertEquals(-16.0, ao02.getPosition().yValue(METER), 0.0001);
        assertEquals(0.0, ao02.getPosition().zValue(METER), 0.0001);

        assertEquals(0.0, ao03.getPosition().xValue(METER), 0.0001);
        assertEquals(4.0, ao03.getPosition().yValue(METER), 0.0001);
        assertEquals(0.0, ao03.getPosition().zValue(METER), 0.0001);
    }

    @Test
    public void moveAllTimes() {

        AstronomicalObject ao01 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao01",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(0.0, KILOGRAM),
                XYZ.valueOf(4.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
        AstronomicalObject ao02 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao02",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(9.0, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );

        AstronomicalObject ao03 = new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "ao03",
                Amount.valueOf(0.0, METER),
                Amount.valueOf(16, KILOGRAM),
                XYZ.valueOf(0.0, -5.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );


        AstronomicalObjectSystem astronomicalObjectSystem = new AstronomicalObjectSystem(
                List.of(ao01, ao02, ao03),
                Amount.valueOf(25.0, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );


        for (int i = 0; i < 999; i++) {
            astronomicalObjectSystem.nextStep();
        }
    }

    @Test
    public void sunEarthTest() {
        AstronomicalObjectSystem astronomicalObjectSystem = new AstronomicalObjectSystem(
                List.of(AstronomicalObjectFactory.earth(), AstronomicalObjectFactory.sun()),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
        for (int i = 0; i < 999; i++) {
            astronomicalObjectSystem.nextStep();
        }
    }


}

























