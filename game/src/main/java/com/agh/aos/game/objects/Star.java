package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicObject;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

import static com.agh.aos.game.Utils3d.*;

public class Star extends AstronomicObjectView {

    private PointLight lightSource;

    public Star(Geometry geometry, AstronomicObject astronomicObject) {
        super(geometry, astronomicObject);
        initLightSource();
    }

    public Star(Geometry geometry, AstronomicObject astronomicObject, Label label) {
        super(geometry, astronomicObject, label);
        initLightSource();
    }

    private void initLightSource() {
        lightSource = new PointLight();
        lightSource.setColor(ColorRGBA.White);
        lightSource.setRadius(1000);
        lightSource.setPosition(fromXYZToVector3f(astronomicObject.getPosition()));
    }

    @Override
    public void updateGeometry(float tpf) {
        Vector3f newTranslation = fromXYZToVector3f(astronomicObject.getPosition());
        geometry.setLocalTranslation(newTranslation);
        geometry.rotate(0f, 0.1f * tpf, 0f);

        lightSource.setPosition(newTranslation);

    }

}
