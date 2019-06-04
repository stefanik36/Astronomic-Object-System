package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicalObject;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

import static com.agh.aos.game.Utils3d.*;

public class Star extends AstronomicObjectView {

    private PointLight lightSource;

    public Star(Geometry geometry, AstronomicalObject astronomicalObject) {
        super(geometry, astronomicalObject);
        initLightSource();
    }

    public Star(Geometry geometry, AstronomicalObject astronomicalObject, Label label) {
        super(geometry, astronomicalObject, label);
        initLightSource();
    }

    private void initLightSource() {
        lightSource = new PointLight();
        lightSource.setColor(ColorRGBA.White);
        lightSource.setRadius(1000);
        lightSource.setPosition(fromXYZToVector3f(astronomicalObject.getPosition()));
    }

    @Override
    public void updateGeometry(float tpf) {
        Vector3f newTranslation = fromXYZToVector3f(astronomicalObject.getPosition());
        geometry.setLocalTranslation(newTranslation);
        geometry.rotate(0f, 0.1f * tpf, 0f);

        lightSource.setPosition(newTranslation);

    }

}
