package com.agh.aos.factory;

import com.agh.aos.model.AstronomicObject;
import com.agh.aos.util.ConstantValues;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;

public class AstronomicObjectFactory {

    /*
     * PLANETS
     */


    public static AstronomicObject cEarth() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }


    public static AstronomicObject mercury() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MERCURY,
                "Mercury",
                Amount.valueOf(ConstantValues.MERCURY_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MERCURY_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MERCURY_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MERCURY_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject venus() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.VENUS,
                "Venus",
                Amount.valueOf(ConstantValues.VENUS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.VENUS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.VENUS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.VENUS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject earth() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject mars() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MARS,
                "Mars",
                Amount.valueOf(ConstantValues.MARS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MARS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MARS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MARS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject jupiter() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.JUPITER,
                "Jupiter",
                Amount.valueOf(ConstantValues.JUPITER_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.JUPITER_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.JUPITER_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.JUPITER_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject saturn() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.SATURN,
                "Saturn",
                Amount.valueOf(ConstantValues.SATURN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SATURN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.SATURN_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.SATURN_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject uranus() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.URANUS,
                "Uranus",
                Amount.valueOf(ConstantValues.URANUS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.URANUS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.URANUS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.URANUS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject neptune() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.NEPTUNE,
                "Neptune",
                Amount.valueOf(ConstantValues.NEPTUNE_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.NEPTUNE_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.NEPTUNE_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.NEPTUNE_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject pluto() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.PLUTO,
                "Pluto",
                Amount.valueOf(ConstantValues.PLUTO_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.PLUTO_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.PLUTO_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.PLUTO_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject earthInCenter() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+04, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject biggerEarth() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.PLANET,
                "Earth",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject abstractPlanet01() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.PLANET,
                "Abstract planet 01",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(5.972e+24, KILOGRAM),
                XYZ.valueOf(4.47095e+11, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 9.03e+8, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject abstractPlanet02() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "Abstract planet 02",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(5.972e+29, KILOGRAM),
                XYZ.valueOf(1.47095e+11, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -3.03e+9, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject earthBiggerVelocity() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "earthBiggerVelocity",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+05, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject earthWithVelocity(double speed) {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.EARTH,
                "Abstract planet 02",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE * 10, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * Math.pow(10, speed / 2), 0.0, METRES_PER_SECOND)
        );
    }


    /*
     * STARS
     */

    public static AstronomicObject sun() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.SUN,
                "Sun",
                Amount.valueOf(ConstantValues.SUN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SUN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }


    public static AstronomicObject abstractStar01() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.STAR,
                "Abstract star 01",
                Amount.valueOf(6.371e+06, METER),
                Amount.valueOf(2.0e+30, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }
    /*
     * SATELLITES
     */

    public static AstronomicObject ecMoon() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject moon() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject biggerMoon() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 10, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE - ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject moonExperimental() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 100, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE * 10 - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+05 - ConstantValues.MOON_VELOCITY_V_VALUE * 90, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject moonBiggerVelocity() {
        return new AstronomicObject(
                AstronomicObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 10, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE - ConstantValues.MOON_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)//* 1.0e+02
        );
    }

}
