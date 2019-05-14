package com.agh.aos.game.objects;

import com.agh.aos.model.AstronomicObject;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

public abstract class AstronomicObjectView {

    Geometry geometry;
    AstronomicObject astronomicObject;

    public AstronomicObjectView(Geometry geometry, AstronomicObject astronomicObject) {
        this.geometry = geometry;
        this.astronomicObject = astronomicObject;
    }

    public abstract void updateGeometry(float tpf);

    public void addToNode(Node node){
        node.attachChild(geometry);
    }

    public AstronomicObject getAstronomicObject() {
        return astronomicObject;
    }

    public void setAstronomicObject(AstronomicObject astronomicObject) {
        this.astronomicObject = astronomicObject;
    }
}
