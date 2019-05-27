package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicObject;
import com.jme3.scene.Geometry;

import static com.agh.aos.game.Utils3d.*;

public class Planet extends AstronomicObjectView {

    public Planet(Geometry geometry, AstronomicObject astronomicObject) {
        super(geometry, astronomicObject);
    }

    public Planet(Geometry geometry, AstronomicObject astronomicObject, Label label) {
        super(geometry, astronomicObject, label);
    }

    @Override
    public void updateGeometry(float tpf) {
        geometry.setLocalTranslation(fromXYZToVector3f(astronomicObject.getPosition()));
        geometry.rotate(0, 0, 0.1f*tpf);
    }

}
