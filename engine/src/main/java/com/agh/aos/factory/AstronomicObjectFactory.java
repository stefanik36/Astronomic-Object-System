package com.agh.aos.factory;

import com.agh.aos.model.AstronomicObject;
import com.agh.aos.util.ConstantValues;
import org.jscience.geography.coordinates.XYZ;
import org.jscience.physics.amount.Amount;

import javax.measure.VectorMeasure;

import static javax.measure.unit.SI.*;

public class AstronomicObjectFactory {


    public static AstronomicObject earth() {
        return new AstronomicObject(
                "Earth",
                Amount.valueOf(ConstantValues.EARTH_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.EARTH_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(ConstantValues.EARTH_POSITION_X_VALUE, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, ConstantValues.EARTH_VELOCITY_V_VALUE, 0.0, METRES_PER_SECOND)
        );
    }

    public static AstronomicObject sun() {
        return new AstronomicObject(
                "Sun",
                Amount.valueOf(ConstantValues.SUN_RADIUS_VALUE, METER),
                Amount.valueOf(ConstantValues.SUN_MASS_VALUE, KILOGRAM),
                XYZ.valueOf(0.0, 0.0, 0.0, METER),
                VectorMeasure.valueOf(0.0, 0.0, 0.0, METRES_PER_SECOND)
        );
    }
}
