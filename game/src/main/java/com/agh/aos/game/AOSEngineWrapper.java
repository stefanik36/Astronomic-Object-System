package com.agh.aos.game;

import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicalObject;
import com.agh.aos.model.AstronomicalObjectSystem;
import com.agh.aos.util.ConstantValues;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import io.vavr.collection.List;

public class AOSEngineWrapper {
    private AstronomicalObjectSystem astronomicalObjectSystem;

    private List<AstronomicObjectView> objectViewList;

    public AOSEngineWrapper(List<AstronomicObjectView> objects) {
        this.objectViewList = objects;
        List<AstronomicalObject> astronomicObjectList = objectViewList.map(AstronomicObjectView::getAstronomicalObject);
        this.astronomicalObjectSystem = new AstronomicalObjectSystem(astronomicObjectList, ConstantValues.GRAVITATIONAL_CONSTANT);
    }


    public AOSEngineWrapper(AstronomicalObjectSystem astronomicalObjectSystem, List<AstronomicObjectView> objectViewList) {
        this.objectViewList = objectViewList;
        this.astronomicalObjectSystem = astronomicalObjectSystem;
    }


    public void nextStep(float tpf) {
        astronomicalObjectSystem.nextStep();
//        objectViewList.forEach(x -> x.updateGeometry(tpf));
    }

    public void updateView(Camera cam, float tpf) {
        objectViewList.forEach(x -> {
            x.updateGeometry(tpf);
            x.updateLabel(cam, tpf);
        });
    }


    public void attachToNode(Node textNode, Node envNode) {
        objectViewList.forEach(x -> x.addToNode(textNode, envNode));
    }


    public AstronomicalObjectSystem getAstronomicalObjectSystem() {
        return astronomicalObjectSystem;
    }

    public List<AstronomicObjectView> getObjectViewList() {
        return objectViewList;
    }

}
