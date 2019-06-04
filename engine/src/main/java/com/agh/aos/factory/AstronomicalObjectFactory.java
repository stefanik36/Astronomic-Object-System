package com.agh.aos.factory;

import com.agh.aos.model.AstronomicalObject;
import com.agh.aos.util.ConstantValues;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;

public class AstronomicalObjectFactory {

    /*
     * PLANETS
     */


    public static AstronomicalObject cEarth() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }


    public static AstronomicalObject mercury() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MERCURY,
                "Mercury",
                Amount.valueOf(ConstantValues.MERCURY_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MERCURY_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MERCURY_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MERCURY_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject venus() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.VENUS,
                "Venus",
                Amount.valueOf(ConstantValues.VENUS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.VENUS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.VENUS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.VENUS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject earth() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject mars() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MARS,
                "Mars",
                Amount.valueOf(ConstantValues.MARS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MARS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MARS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MARS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject jupiter() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.JUPITER,
                "Jupiter",
                Amount.valueOf(ConstantValues.JUPITER_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.JUPITER_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.JUPITER_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.JUPITER_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject saturn() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.SATURN,
                "Saturn",
                Amount.valueOf(ConstantValues.SATURN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SATURN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.SATURN_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.SATURN_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject uranus() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.URANUS,
                "Uranus",
                Amount.valueOf(ConstantValues.URANUS_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.URANUS_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.URANUS_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.URANUS_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject neptune() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.NEPTUNE,
                "Neptune",
                Amount.valueOf(ConstantValues.NEPTUNE_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.NEPTUNE_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.NEPTUNE_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.NEPTUNE_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject pluto() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLUTO,
                "Pluto",
                Amount.valueOf(ConstantValues.PLUTO_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.PLUTO_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.PLUTO_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.PLUTO_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject earthInCenter() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+04, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject biggerEarth() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Earth",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject abstractPlanet01() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "Abstract planet 01",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(5.972e+24, KILOGRAM),
                XYZ.valueOf(4.47095e+11, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 9.03e+8, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject abstractPlanet02() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "Abstract planet 02",
                Amount.valueOf(6.371e+07, METER),
                Amount.valueOf(5.972e+29, KILOGRAM),
                XYZ.valueOf(1.47095e+11, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -3.03e+9, 0.0, METRES_PER_SECOND)
        );
    }


    public static AstronomicalObject abstract3dPlanet01() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "Abstract 3d planet 01",
                Amount.valueOf(6.371e+06, METER),
                Amount.valueOf(5.972e+24, KILOGRAM),
                XYZ.valueOf(-1.47095e+11, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -3.03e+04, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject abstract3dPlanet02() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.PLANET,
                "Abstract 3Z planet 02",
                Amount.valueOf(6.371e+06, METER),
                Amount.valueOf(5.972e+24, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, -1.47095e+11, METER),
                VectorMeasure.valueOf(0.0, -3.03e+9, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject earthBiggerVelocity() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
                "earthBiggerVelocity",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+05, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject earthWithVelocity(double speed) {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.EARTH,
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

    public static AstronomicalObject sun() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.SUN,
                "Sun",
                Amount.valueOf(ConstantValues.SUN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SUN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }


    public static AstronomicalObject abstractStar01() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.STAR,
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

    public static AstronomicalObject ecMoon() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject moon() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject biggerMoon() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 10, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE - ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject moonExperimental() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 100, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.MOON_POSITION_X_VALUE * 10 - ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, -ConstantValues.EARTH_VELOCITY_V_VALUE * 1.0e+05 - ConstantValues.MOON_VELOCITY_V_VALUE * 90, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicalObject moonBiggerVelocity() {
        return new AstronomicalObject(
                AstronomicalObject.AstronomicObjectType.MOON,
                "Moon",
                Amount.valueOf(ConstantValues.MOON_RADIUS_VALUE * 10, METER),
                Amount.valueOf(ConstantValues.MOON_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(-ConstantValues.EARTH_POSITION_X_VALUE - ConstantValues.MOON_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, ConstantValues.MOON_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)//* 1.0e+02
        );
    }

}
