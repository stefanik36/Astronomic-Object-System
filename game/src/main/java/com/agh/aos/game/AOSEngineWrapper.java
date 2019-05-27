package com.agh.aos.game;

import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicObject;
import com.agh.aos.model.AstronomicObjectSystem;
import com.agh.aos.util.ConstantValues;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import io.vavr.collection.List;

public class AOSEngineWrapper {
    private AstronomicObjectSystem astronomicObjectSystem;

    private List<AstronomicObjectView> objectViewList;

    public AOSEngineWrapper(List<AstronomicObjectView> objects) {
        this.objectViewList = objects;
        List<AstronomicObject> astronomicObjectList = objectViewList.map(AstronomicObjectView::getAstronomicObject);
        this.astronomicObjectSystem = new AstronomicObjectSystem(astronomicObjectList, ConstantValues.GRAVITATIONAL_CONSTANT);
    }


    public AOSEngineWrapper(AstronomicObjectSystem astronomicObjectSystem, List<AstronomicObjectView> objectViewList) {
        this.objectViewList = objectViewList;
        this.astronomicObjectSystem = astronomicObjectSystem;
    }


    public void nextStep(float tpf) {
        astronomicObjectSystem.nextStep();
//        objectViewList.forEach(x -> x.updateGeometry(tpf));
    }

    public void updateView(Camera cam, float tpf){
        objectViewList.forEach(x -> {x.updateGeometry(tpf); x.updateLabel(cam, tpf);});
    }



    public void attachToNode(Node textNode, Node envNode) {
        objectViewList.forEach(x -> x.addToNode(textNode, envNode));
    }


    public List<AstronomicObjectView> getObjectViewList() {
        return objectViewList;
    }

}
