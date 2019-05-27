package com.agh.aos.game.factory;

import com.agh.aos.factory.AstronomicObjectFactory;
import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.game.objects.Planet;
import com.agh.aos.game.objects.Star;
import com.agh.aos.model.AstronomicObject;
import com.agh.aos.model.AstronomicObjectSystem;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.TangentBinormalGenerator;
import io.vavr.collection.List;

import javax.measure.unit.SI;

import static com.agh.aos.game.Config.RADIUS_SCALE;
import static com.agh.aos.game.Utils3d.fromXYZToVector3f;

public class AstronomicObjectViewFactory {


    public static Planet biggerEarth(AssetManager manager) {
        AstronomicObject obj = AstronomicObjectFactory.biggerEarth();
        Material m = new Material(manager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        m.setColor("Color", ColorRGBA.Green);
        m.setTexture("NormalMap",
                manager.loadTexture("Textures/EarthHighRes/2k_earth_daymap.jpg"));

        Geometry geometry = createGeometry(obj, m); // only sun model is working XD

        return new Planet(geometry, obj);
    }

    public static Planet earth(AssetManager manager) {
        AstronomicObject obj = AstronomicObjectFactory.earth();
        Material m = new Material(manager, "Common/MatDefs/Misc/Unshaded.j3md");
        m.setTexture("NormalMap",
                manager.loadTexture("Textures/EarthHighRes/2k_earth_daymap.jpg"));

        Geometry geometry = createGeometry(obj, m); // only sun model is working XD

        return new Planet(geometry, obj);
    }

    public static Star sun(AssetManager manager) {
        AstronomicObject obj = AstronomicObjectFactory.sun();

        Geometry geometry = createGeometry(obj, manager.loadMaterial("Materials/Sun.j3m"));
        return new Star(geometry, obj);
    }

    public static List<AstronomicObjectView> toView(AstronomicObjectSystem astronomicObjectSystem, AssetManager manager) {
        List<AstronomicObject.AstronomicObjectType> starMaterialTypes = List.of(AstronomicObject.AstronomicObjectType.SUN, AstronomicObject.AstronomicObjectType.STAR);
        List<AstronomicObject.AstronomicObjectType> planetMaterialTypes = List.of(AstronomicObject.AstronomicObjectType.EARTH, AstronomicObject.AstronomicObjectType.PLANET);
        List<AstronomicObject.AstronomicObjectType> satellitesMaterialTypes = List.of(AstronomicObject.AstronomicObjectType.MOON, AstronomicObject.AstronomicObjectType.SATELLITE);

        return astronomicObjectSystem.getAstronomicObjectList().map(ao -> {
            if (starMaterialTypes.contains(ao.getType())) {
                return toStar(ao, manager);
            } else if (planetMaterialTypes.contains(ao.getType())) {
                return toPlanet(ao, manager);
            } else if (satellitesMaterialTypes.contains(ao.getType())) {
                return toSatellites(ao, manager);
            } else {
                return toOther(ao, manager);
//                throw new RuntimeException(new UnsupportedOperationException()); //TODO set other materials
            }
        });
    }

    private static AstronomicObjectView toSatellites(AstronomicObject ao, AssetManager manager) {
        Material m = new Material(manager, "Common/MatDefs/Misc/Unshaded.j3md");
        m.setColor("Color", ColorRGBA.Red);
        var label = LabelFactory.textWithMarker(ao.getName(), manager);//TODO some material for satellites

        Geometry geometry = createGeometry(ao, m);
        return new Planet(geometry, ao, label);
    }

    private static AstronomicObjectView toPlanet(AstronomicObject ao, AssetManager manager) {
        Material m = new Material(manager, "Common/MatDefs/Misc/Unshaded.j3md");
//        m.setColor("Color", ColorRGBA.Green)

        m.setTexture("ColorMap",
                manager.loadTexture("Textures/EarthHighRes/2k_earth_daymap.jpg"));

        Geometry geometry = createGeometry(ao, m);
        var label = LabelFactory.textWithMarker(ao.getName(), manager);
        return new Planet(geometry, ao, label);
    }

    private static AstronomicObjectView toOther(AstronomicObject ao, AssetManager manager) {
        Material m = new Material(manager, "Common/MatDefs/Misc/Unshaded.j3md");
        m.setColor("Color", ColorRGBA.randomColor());
        var label = LabelFactory.textWithMarker(ao.getName(), manager);//TODO some material for other

        Geometry geometry = createGeometry(ao, m);
        return new Planet(geometry, ao, label);
    }

    private static AstronomicObjectView toStar(AstronomicObject ao, AssetManager manager) {
        Geometry geometry = createGeometry(ao, manager.loadMaterial("Materials/Sun.j3m"));

        var label = LabelFactory.textWithMarker(ao.getName(), manager);
        return new Star(geometry, ao, label);
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
