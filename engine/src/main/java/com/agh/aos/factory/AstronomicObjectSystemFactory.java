package com.agh.aos.factory;

import com.agh.aos.model.AstronomicObjectSystem;
import com.agh.aos.util.ConstantValues;
import io.vavr.collection.List;
import org.jscience.physics.amount.Amount;

import static javax.measure.unit.SI.*;
import static javax.measure.unit.SI.SECOND;

public class AstronomicObjectSystemFactory {


    public static AstronomicObjectSystem sunEarth() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicObjectSystem sunMercuryEarth() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem sunMercuryVenusEarth() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.venus(),
                        AstronomicObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem sunMercuryVenusEarthMars() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.venus(),
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.mars()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem sunMercuryVenusEarthMarsJupiter() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.venus(),
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.mars(),
                        AstronomicObjectFactory.jupiter()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem sunMercuryVenusEarthMarsJupiterSaturn() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.venus(),
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.mars(),
                        AstronomicObjectFactory.jupiter(),
                        AstronomicObjectFactory.saturn()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem solarSystem() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.mercury(),
                        AstronomicObjectFactory.venus(),
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.mars(),
                        AstronomicObjectFactory.jupiter(),
                        AstronomicObjectFactory.saturn(),
                        AstronomicObjectFactory.uranus(),
                        AstronomicObjectFactory.neptune(),
                        AstronomicObjectFactory.pluto()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem cEarthEcMoon() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.cEarth(),
                        AstronomicObjectFactory.ecMoon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem earthMoon() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.moon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicObjectSystem sunEarthMoon() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.earth(),
                        AstronomicObjectFactory.moon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicObjectSystem biggerEarthAndSun() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.biggerEarth(),
                        AstronomicObjectFactory.sun()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicObjectSystem sunBiggerEarthBiggerMoon() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.biggerEarth(),
                        AstronomicObjectFactory.biggerMoon()
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

    public static AstronomicObjectSystem sunEarthBiggerVelocityMoonBiggerVelocity() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.earthBiggerVelocity(),
                        AstronomicObjectFactory.moonBiggerVelocity()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicObjectSystem earthInCenterMoon() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.sun(),
                        AstronomicObjectFactory.earthBiggerVelocity(),
                        AstronomicObjectFactory.moonExperimental()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }


    public static AstronomicObjectSystem abstractPlanet01AbstractPlane02Sun() {
        return new AstronomicObjectSystem(
                List.of(
                        AstronomicObjectFactory.abstractPlanet01(),
                        AstronomicObjectFactory.abstractPlanet02(),
                        AstronomicObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }


    /**
     * @param speed simulation speed (decreases gravitational constant and increases initial earth velocity)
     * @return earth with proper gravitational constant and initial earth velocity
     * @Deprecated use AstronomicObjectSystem.setStepSize() to change simulation speed
     */
    @Deprecated
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
