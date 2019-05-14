package com.agh.aos.game.factory;

import com.agh.aos.factory.AstronomicObjectFactory;
import com.agh.aos.game.objects.Planet;
import com.agh.aos.game.objects.Star;
import com.agh.aos.model.AstronomicObject;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.TangentBinormalGenerator;

import javax.measure.unit.SI;

import static com.agh.aos.game.Config.RADIUS_SCALE;
import static com.agh.aos.game.Utils3d.fromXYZToVector3f;

public class AstronomicObjectViewFactory {

    public static Planet earth(AssetManager manager) {
        AstronomicObject obj = AstronomicObjectFactory.earth();
        Material m = new Material(manager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        m.setColor("Color", ColorRGBA.Green);
        Geometry geometry = createGeometry(obj, m); // only sun model is working XD

        return new Planet(geometry, obj);
    }

    public static Star sun(AssetManager manager) {
        AstronomicObject obj = AstronomicObjectFactory.sun();

        Geometry geometry = createGeometry(obj, manager.loadMaterial("Materials/Sun.j3m"));
        return new Star(geometry, obj);
    }


    private static Geometry createGeometry(AstronomicObject obj, Material material) {
        Sphere s = new Sphere(128, 128, (float) obj.getRadius().doubleValue(SI.METER) * RADIUS_SCALE);
        TangentBinormalGenerator.generate(s);
        s.setTextureMode(Sphere.TextureMode.Projected);

        Geometry geometry = new Geometry(obj.getName(), s);
        geometry.setLocalTranslation(fromXYZToVector3f(obj.getPosition()));

        geometry.setMaterial(material);
        return geometry;

    }
}
