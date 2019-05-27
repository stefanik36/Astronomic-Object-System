package com.agh.aos.game.factory;

import com.agh.aos.game.objects.FontManager;
import com.agh.aos.game.objects.Label;
import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;

public class LabelFactory {

//    public static Label textWithMarker(AssetManager manager){
//
//    }

    public static Label textWithMarker(String text, AssetManager manager) {
        var font = manager.loadFont("Interface/Fonts/Default.fnt");
        var q = new Quad(5f,5f);
        var geom = new Geometry("Marker" + text, q);
        var material = new Material(manager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(material);

        return new Label(text, font, geom);
    }

    public static Label onlyText(String text, AssetManager manager) {
        var font = manager.loadFont("Interface/Fonts/Default.fnt");
        return new Label(text, font);
    }

}
