package com.agh.aos.util;

import org.jscience.physics.amount.Amount;
import org.jscience.physics.amount.Constants;

public class ConstantValues {
    /**
     * m^3⋅kg^−1⋅s^−2
     */
    public static final Amount<?> GRAVITATIONAL_CONSTANT = Constants.G; // value (6.67408e-11)
    /**
     * m
     */
    public static final double EARTH_RADIUS_VALUE = 6.371e+06;
    /**
     * kg
     */
    public static final double EARTH_MASS_VALUE = 5.972e+24;
    /**
     * m
     */
    public static final double EARTH_POSITION_X_VALUE = -1.47095e+11;
    /**
     * m / s
     */
    public static final double EARTH_VELOCITY_V_VALUE = -3.03e+04;

    /**
     * m
     */
    public static final double SUN_RADIUS_VALUE = 6.957e+08;
    /**
     * kg
     */
    public static final double SUN_MASS_VALUE = 1.989e+30;

}
