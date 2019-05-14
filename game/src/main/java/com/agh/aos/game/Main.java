package com.agh.aos.game;

import com.agh.aos.factory.AstronomicObjectSystemFactory;
import com.agh.aos.game.factory.AstronomicObjectViewFactory;
import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicObjectSystem;
import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;
import io.vavr.collection.List;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setWidth(1280);
        settings.setHeight(720);
//        settings.setFrameRate(60);
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    private AOSEngineWrapper gravityEngine = null;

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(2000f);
        cam.setLocation(new Vector3f(-1000, 0, 12000));
        cam.setFrustumFar(30000);
        cam.onFrameChange();

//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthSunWithSpeed(13.0));
        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.abstractPlanet01AbstractPlane02Sun());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunEarthBiggerVelocityMoonBiggerVelocity());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthBiggerVelocitySun_AroundSun());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthInCenterMoon());
//        this.gravityEngine = getEngine();
        gravityEngine.attachToNode(rootNode);


//        Spatial gameLevel = assetManager.loadModel("Scenes/town/main.scene");
//        gameLevel.setLocalTranslation(-110f, -40f, 0);
//        gameLevel.setLocalScale(2);
//        rootNode.attachChild(gameLevel);

        initializeSky();
    }

    private AOSEngineWrapper getEngine(AstronomicObjectSystem astronomicObjectSystem) {
        List<AstronomicObjectView> astronomicObjects = AstronomicObjectViewFactory.toView(astronomicObjectSystem, this.assetManager);
        return new AOSEngineWrapper(astronomicObjectSystem, astronomicObjects);
    }


    private AOSEngineWrapper getEngine() {
        List<AstronomicObjectView> astronomicObjects = List.of(
                AstronomicObjectViewFactory.sun(assetManager),
                AstronomicObjectViewFactory.earth(assetManager)
        );
        return new AOSEngineWrapper(astronomicObjects);
    }


    private void initializeSky() {
        Texture west = getAssetManager().loadTexture("Textures/Sky/Milkyway/west.jpg");
        Texture east = getAssetManager().loadTexture("Textures/Sky/Milkyway/east.jpg");
        Texture north = getAssetManager().loadTexture("Textures/Sky/Milkyway/north.jpg");
        Texture south = getAssetManager().loadTexture("Textures/Sky/Milkyway/south.jpg");
        Texture up = getAssetManager().loadTexture("Textures/Sky/Milkyway/up.jpg");
        Texture down = getAssetManager().loadTexture("Textures/Sky/Milkyway/down.jpg");
        getRootNode().attachChild(SkyFactory.createSky(getAssetManager(), west, east, north, south, up, down));
    }


    @Override
    public void simpleUpdate(float tpf) {
        gravityEngine.nextStep(tpf);

    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
