package com.agh.aos.factory;

import com.agh.aos.model.AstronomicObjectSystem;
import com.agh.aos.util.ConstantValues;
import io.vavr.collection.List;
import org.jscience.physics.amount.Amount;

import static javax.measure.unit.SI.*;
import static javax.measure.unit.SI.SECOND;

public class AstronomicObjectSystemFactory {


    public static AstronomicObjectSystem biggerEarthAndSun() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.biggerEarth(),
                        AstronomicObjectFactory.sun()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicObjectSystem earthAndSunBiggerGravitation() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.sun()
                ),
                Amount.valueOf(5.0e-09, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicObjectSystem abstractPlanet01AbstractStar01() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.abstractPlanet01(),
                        AstronomicObjectFactory.abstractStar01()
                ),
                Amount.valueOf(5.0e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicObjectSystem abstractPlanet01Sun_AroundSun() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.abstractPlanet01(),
                        AstronomicObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-3, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }


    public static AstronomicObjectSystem earthBiggerVelocitySun_AroundSun() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.earthBiggerVelocity(),
                        AstronomicObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    /**
     * @param speed simulation speed (decreases gravitational constant and increases initial earth velocity)
     * @return earth with proper gravitational constant and initial earth velocity
     */
    public static AstronomicObjectSystem earthSunWithSpeed(double speed) {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.earthWithVelocity(speed),
                        AstronomicObjectFactory.sun()
                ),
                Amount.valueOf(6.67408e-11 * Math.pow(10, speed), CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

}
