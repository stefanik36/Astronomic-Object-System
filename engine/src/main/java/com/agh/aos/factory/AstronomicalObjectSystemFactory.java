package com.agh.aos.factory;

import com.agh.aos.model.AstronomicalObjectSystem;
import com.agh.aos.util.ConstantValues;
import io.vavr.collection.List;
import org.jscience.physics.amount.Amount;

import static javax.measure.unit.SI.*;
import static javax.measure.unit.SI.SECOND;

public class AstronomicalObjectSystemFactory {


    public static AstronomicalObjectSystem sunEarth() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicalObjectSystem sunMercuryEarth() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem sunMercuryVenusEarth() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.venus(),
                        AstronomicalObjectFactory.earth()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem sunMercuryVenusEarthMars() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.venus(),
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.mars()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem sunMercuryVenusEarthMarsJupiter() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.venus(),
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.mars(),
                        AstronomicalObjectFactory.jupiter()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem sunMercuryVenusEarthMarsJupiterSaturn() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.venus(),
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.mars(),
                        AstronomicalObjectFactory.jupiter(),
                        AstronomicalObjectFactory.saturn()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem solarSystem() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.mercury(),
                        AstronomicalObjectFactory.venus(),
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.mars(),
                        AstronomicalObjectFactory.jupiter(),
                        AstronomicalObjectFactory.saturn(),
                        AstronomicalObjectFactory.uranus(),
                        AstronomicalObjectFactory.neptune(),
                        AstronomicalObjectFactory.pluto()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem cEarthEcMoon() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.cEarth(),
                        AstronomicalObjectFactory.ecMoon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem earthMoon() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.moon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }

    public static AstronomicalObjectSystem sunEarthMoon() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.moon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicalObjectSystem biggerEarthAndSun() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.biggerEarth(),
                        AstronomicalObjectFactory.sun()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicalObjectSystem sunBiggerEarthBiggerMoon() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.biggerEarth(),
                        AstronomicalObjectFactory.biggerMoon()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    public static AstronomicalObjectSystem earthAndSunBiggerGravitation() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.earth(),
                        AstronomicalObjectFactory.sun()
                ),
                Amount.valueOf(5.0e-09, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicalObjectSystem abstractPlanet01AbstractStar01() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.abstractPlanet01(),
                        AstronomicalObjectFactory.abstractStar01()
                ),
                Amount.valueOf(5.0e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicalObjectSystem abstractPlanet01Sun_AroundSun() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.abstractPlanet01(),
                        AstronomicalObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-3, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }


    public static AstronomicalObjectSystem earthBiggerVelocitySun_AroundSun() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.earthBiggerVelocity(),
                        AstronomicalObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicalObjectSystem sunEarthBiggerVelocityMoonBiggerVelocity() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.earthBiggerVelocity(),
                        AstronomicalObjectFactory.moonBiggerVelocity()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicalObjectSystem earthInCenterMoon() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
                        AstronomicalObjectFactory.earthBiggerVelocity(),
                        AstronomicalObjectFactory.moonExperimental()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }


    public static AstronomicalObjectSystem abstractPlanet01AbstractPlane02Sun() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.abstractPlanet01(),
                        AstronomicalObjectFactory.abstractPlanet02(),
                        AstronomicalObjectFactory.sun()
                ),
                Amount.valueOf(6.6e-01, CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }

    public static AstronomicalObjectSystem system3d() {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.sun(),
//                        AstronomicalObjectFactory.abstract3dPlanet01(),
                        AstronomicalObjectFactory.abstract3dPlanet02()
                ),
                ConstantValues.GRAVITATIONAL_CONSTANT
        );
    }


    /**
     * @param speed simulation speed (decreases gravitational constant and increases initial earth velocity)
     * @return earth with proper gravitational constant and initial earth velocity
     * @Deprecated use AstronomicalObjectSystem.setStepSize() to change simulation speed
     */
    @Deprecated
    public static AstronomicalObjectSystem earthSunWithSpeed(double speed) {
        return new AstronomicalObjectSystem(
                List.of(
                        AstronomicalObjectFactory.earthWithVelocity(speed),
                        AstronomicalObjectFactory.sun()
                ),
                Amount.valueOf(6.67408e-11 * Math.pow(10, speed), CUBIC_METRE.divide(KILOGRAM).divide(SECOND).divide(SECOND))
        );
    }



}
