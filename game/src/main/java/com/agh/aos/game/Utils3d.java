package com.agh.aos.game;

import com.jme3.math.Vector3f;
import org.jscience.geography.coordinates.XYZ;

import static com.agh.aos.game.Config.*;

import javax.measure.unit.SI;

public class Utils3d {

    static public Vector3f fromXYZToVector3f(XYZ xyz) {
        return new Vector3f((float) xyz.xValue(SI.METER) * DIST_SCALE * SPECIAL_DIST_X_SCALE,
                (float) xyz.yValue(SI.METER) * DIST_SCALE * SPECIAL_DIST_Y_SCALE,
                (float) xyz.zValue(SI.METER) * DIST_SCALE * SPECIAL_DIST_Z_SCALE);
    }
}
