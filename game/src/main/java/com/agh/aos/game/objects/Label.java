package com.agh.aos.game.objects;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.control.BillboardControl;
import com.jme3.scene.shape.Quad;

public class Label {

    private String text;
    private BitmapText text3d;
    private Geometry marker;
    private BillboardControl control;

    public Label(String text, BitmapFont font) {
        this.text = text;
        text3d = new BitmapText(font);
        text3d.setSize(font.getCharSet().getRenderedSize());      // font size
//        control = new BillboardControl();
//        control.setAlignment(BillboardControl.Alignment.Screen);

        text3d.setColor(ColorRGBA.Blue);                             // font color
//        text3d.addControl(control);
        text3d.setText(text);
//        text3d.setQueueBucket(RenderQueue.Bucket.Transparent);
    }

    public Label(String text, BitmapFont font, Geometry marker) {
        this(text, font);
        this.marker = marker;
    }

    public void setTranslation(Vector3f vector3f, Float radius){
        text3d.setLocalTranslation(vector3f);
        if(marker != null){
            marker.setLocalTranslation(vector3f);
        }
    }

    public void attachToNode(Node node){
        node.attachChild(text3d);
        if(marker != null){
            node.attachChild(marker);
        }

    }


}
