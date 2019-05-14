package com.agh.aos.util;

import io.vavr.collection.List;
import org.jscience.mathematics.number.Float64;
import org.jscience.mathematics.vector.Float64Vector;

import javax.measure.VectorMeasure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public class VectorUtil {

    public static <Q extends Quantity> VectorMeasure<Q> float64VectorToVectorMeasure(Float64Vector v64, Unit<Q> unit) {
        return VectorMeasure.valueOf(
                List.range(0, v64.getDimension())
                        .map(v64::getValue).toJavaStream()
                        .mapToDouble(v -> v).toArray(),
                unit
        );
    }

    public static double length(Float64Vector deltaPosition) {
        return Math.sqrt(List.range(0, deltaPosition.getDimension())
                .map(i -> deltaPosition.getValue(i) * deltaPosition.getValue(i))
                .sum()
                .doubleValue());
    }
}
