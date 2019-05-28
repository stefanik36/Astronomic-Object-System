package com.agh.aos.game;

import com.agh.aos.factory.AstronomicObjectSystemFactory;
import com.agh.aos.game.factory.AstronomicObjectViewFactory;
import com.agh.aos.game.gui.GuiController;
import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicObjectSystem;
import com.jayfella.jme.jfx.JavaFxUI;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;
import io.vavr.collection.List;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

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
        settings.setFrameRate(60);
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

//    TestJavaFx() {
//        super(new StatsAppState());
//    }

    private AOSEngineWrapper gravityEngine = null;
    private Node textNode = new Node("text node");
    private Node envNode = new Node("environment node");
    private OnObjectCameraFocusHolder onObjectCameraFocusHolder = null;

    GuiController guiController = new GuiController(this);
    private boolean isRunning = true;


    @Override
    public void simpleInitApp() {
        rootNode.attachChild(envNode);
        rootNode.attachChild(textNode);
        flyCam.setEnabled(false);
        flyCam.setMoveSpeed(2000f);

        onObjectCameraFocusHolder = new OnObjectCameraFocusHolder(cam);
        startCameraPosition();
        cam.setFrustumFar(300000);
        cam.onFrameChange();

        JavaFxUI.initialize(this);
        initializeSky();
        initializeCustomInputMapping();

        /*
         * when 60 frames per second: 60 sec * 1.0e+05 = 600 000 sec ~ 6.9444444 real days is 1 second of simulation for appSpeed = 1.0e+05
         */
        double appSpeed = 1.0e+05;

//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunMercuryEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunMercuryVenusEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunMercuryVenusEarthMars().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunMercuryVenusEarthMarsJupiter().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunMercuryVenusEarthMarsJupiterSaturn().setStepSize(appSpeed));
        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.solarSystem().setStepSize(appSpeed));


//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthMoon().setStepSize(1.0));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.cEarthEcMoon().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunEarthMoon().setStepSize(10));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.biggerEarthAndSun());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunBiggerEarthBiggerMoon());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthSunWithSpeed(13.0));
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.abstractPlanet01AbstractPlane02Sun());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.sunEarthBiggerVelocityMoonBiggerVelocity());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthBiggerVelocitySun_AroundSun());
//        this.gravityEngine = getEngine(AstronomicObjectSystemFactory.earthInCenterMoon());
//        this.gravityEngine = getEngine();
        gravityEngine.attachToNode(guiNode, envNode);


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui.fxml"));
            loader.setController(guiController);
            JavaFxUI.attachChild(loader.load());
            gravityEngine.getObjectViewList().forEach(x -> guiController.initializeObjButton(cam, x));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    int limiter = 0;

    @Override
    public void simpleUpdate(final float tpf) {
        if (isRunning) {
//            if(limiter == 10) {
            gravityEngine.nextStep(tpf);
//                limiter = 0;
//            }
//            limiter++;
        }
        gravityEngine.updateView(cam, tpf);
        onObjectCameraFocusHolder.focusOnTargetIfSet();
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    public void startCameraPosition() {
        cam.setLocation(new Vector3f(-1000, 0, 12000));
    }

    private void initializeCustomInputMapping() {
        inputManager.addMapping("Toggle fly camera", new KeyTrigger(KeyInput.KEY_C));
        inputManager.addMapping("Pause Game", new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Toggle GUI", new KeyTrigger(KeyInput.KEY_G));


        var pauseListener = new ActionListener() {

            @Override
            public void onAction(String name, boolean isPressed, float tpf) {
                switch (name) {
                    case "Pause Game":
                        if (!isPressed) isRunning = !isRunning;
                        break;
                    case "Toggle GUI":
                        if (!isPressed) guiController.setVisible(!guiController.isVisible());
                }
            }
        };

        inputManager.addListener(pauseListener, "Pause Game", "Toggle GUI");

        var listener = new ActionListener() {
            private boolean status = false;

            @Override
            public void onAction(String name, boolean isPressed, float tpf) {
                if (isPressed) return;

                if (flyCam.isEnabled()) {
                    flyCam.setEnabled(false);
                    getInputManager().setCursorVisible(true);
                } else {
                    flyCam.setEnabled(true);
                    getInputManager().setCursorVisible(false);
                }
            }
        };

        inputManager.addListener(listener, "Toggle fly camera");
    }

    public OnObjectCameraFocusHolder getOnObjectCameraFocusHolder() {
        return onObjectCameraFocusHolder;
    }

    public double getAppSpeed() {
        return gravityEngine.getAstronomicObjectSystem().getStepSize();
    }

    public void setAppSpeed(double appSpeed) {
        gravityEngine.getAstronomicObjectSystem().setStepSize(1.0 * Math.pow(10, appSpeed));
    }
}
