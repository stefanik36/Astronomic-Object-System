package com.agh.aos.game;

import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicObjectSystem;
import com.agh.aos.util.ConstantValues;
import com.jme3.scene.Node;
import io.vavr.collection.List;

public class AOSEngineWrapper {
    private AstronomicObjectSystem astronomicObjectSystem;

    private List<AstronomicObjectView> objectViewList;

    public AOSEngineWrapper(List<AstronomicObjectView> objects) {
        this.objectViewList = objects;
        List astronomicObjectList = objectViewList.map(AstronomicObjectView::getAstronomicObject);
        this.astronomicObjectSystem = new AstronomicObjectSystem(astronomicObjectList, ConstantValues.GRAVITATIONAL_CONSTANT);
    }


    public void nextStep(float tpf){
        astronomicObjectSystem.nextStep();
        objectViewList.forEach(x -> x.updateGeometry(tpf));
    }

    public void attachToNode(Node node){
        objectViewList.forEach(x -> x.addToNode(node));
    }
}
