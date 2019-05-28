package com.agh.aos.game.objects;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

public class Label {

    private String text;
    private BitmapText text3d;
    private Geometry marker;

    public Label(String text, BitmapFont font) {
        this.text = text;
        text3d = new BitmapText(font);
        text3d.setSize(font.getCharSet().getRenderedSize());      // font size
        text3d.setColor(ColorRGBA.Blue);                             // font color
        text3d.setText(text);
    }

    public Label(String text, BitmapFont font, Geometry marker) {
        this(text, font);
        this.marker = marker;
    }

    public void setTranslation(Vector3f vector3f, Float radius) {
        // return if camera is pointing in the opposite direction
        if (vector3f.z > 1) return;
        text3d.setLocalTranslation(vector3f);
        if (marker != null) {
            marker.setLocalTranslation(vector3f);
        }
    }

    public void attachToNode(Node node) {
        node.attachChild(text3d);
        if (marker != null) {
            node.attachChild(marker);
        }

    }


}
