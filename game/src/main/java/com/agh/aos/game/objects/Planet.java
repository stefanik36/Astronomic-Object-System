package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicalObject;
import com.jme3.scene.Geometry;

import static com.agh.aos.game.Utils3d.*;

public class Planet extends AstronomicObjectView {

    public Planet(Geometry geometry, AstronomicalObject astronomicalObject) {
        super(geometry, astronomicalObject);
    }

    public Planet(Geometry geometry, AstronomicalObject astronomicalObject, Label label) {
        super(geometry, astronomicalObject, label);
    }

    @Override
    public void updateGeometry(float tpf) {
        geometry.setLocalTranslation(fromXYZToVector3f(astronomicalObject.getPosition()));
        geometry.rotate(0, 0, 0.1f * tpf);
    }

}
