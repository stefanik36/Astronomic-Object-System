package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicObject;
import com.jme3.scene.Geometry;

import static com.agh.aos.game.Utils3d.*;

public class Planet extends AstronomicObjectView {

    public Planet(Geometry geometry, AstronomicObject astronomicObject) {
        super(geometry, astronomicObject);
    }

    @Override
    public void updateGeometry(float tpf) {
        geometry.setLocalTranslation(fromXYZToVector3f(astronomicObject.getPosition()));
        geometry.rotate(0f, 0.1f * tpf, 0f);
    }

}
