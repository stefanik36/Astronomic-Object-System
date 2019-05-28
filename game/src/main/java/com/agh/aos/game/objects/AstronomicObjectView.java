package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicObject;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

public abstract class AstronomicObjectView {

    Geometry geometry;
    AstronomicObject astronomicObject;
    Label label;

    boolean displayLabel = false;

    public AstronomicObjectView(Geometry geometry, AstronomicObject astronomicObject) {
        this.geometry = geometry;
        this.astronomicObject = astronomicObject;
    }


    public AstronomicObjectView(Geometry geometry, AstronomicObject astronomicObject, Label label) {
        this.geometry = geometry;
        this.astronomicObject = astronomicObject;
        this.label = label;
        if (this.label != null) {
            displayLabel = true;
        }
    }


    public abstract void updateGeometry(float tpf);

    public void updateLabel(Camera cam, float tpf) {
        if (displayLabel && label != null) {
            label.setTranslation(cam.getScreenCoordinates(geometry.getLocalTranslation()), unwrapRadius());
        }
    }


    public void addToNode(Node textNode, Node envNode) {
        envNode.attachChild(geometry);
        if (label != null) {
            label.attachToNode(textNode);
        }
    }

    public AstronomicObject getAstronomicObject() {
        return astronomicObject;
    }

    public Vector3f focusCameraOn(Camera cam) {
        cam.setLocation(geometry.getLocalTranslation().add(new Vector3f(0f, 0f, 20 * unwrapRadius())));
        return geometry.getLocalTranslation();
    }


    public void setAstronomicObject(AstronomicObject astronomicObject) {
        this.astronomicObject = astronomicObject;
    }

    private float unwrapRadius() {
        return ((Sphere) geometry.getMesh()).radius;
    }
}
