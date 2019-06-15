package com.agh.aos.game;

import com.agh.aos.factory.AstronomicalObjectSystemFactory;
import com.agh.aos.game.factory.AstronomicObjectViewFactory;
import com.agh.aos.game.gui.GuiController;
import com.agh.aos.game.objects.AstronomicObjectView;
import com.agh.aos.model.AstronomicalObjectSystem;
import com.jayfella.jme.jfx.JavaFxUI;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;
import io.vavr.collection.List;
import javafx.application.Platform;
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
//        app.setShowSettings(false);
        app.start();
    }

    private AOSEngineWrapper gravityEngine = null;
    private Node envNode = new Node("environment node");
    private OnObjectCameraFocusHolder onObjectCameraFocusHolder = null;

    private GuiController guiController = new GuiController(this);
    private boolean isRunning = true;
    private boolean isInitialized = false;


    @Override
    public void simpleUpdate(final float tpf) {
        if (!isInitialized) return;
        if (isRunning) {
            gravityEngine.nextStep(tpf);
        }
        gravityEngine.updateView(cam, tpf);
        onObjectCameraFocusHolder.focusOnTargetIfSet();
    }

    @Override
    public void simpleInitApp() {
        var initText = showInitializationMessage();
        rootNode.attachChild(envNode);
        flyCam.setEnabled(false);
        flyCam.setMoveSpeed(2000f);

        onObjectCameraFocusHolder = new OnObjectCameraFocusHolder(cam);
        startCameraPosition();
        cam.setFrustumFar(300000);
        cam.onFrameChange();

        JavaFxUI.initialize(this);
        initializeSky();
        initializeCustomInputMapping();
        initializeJavaFxGui();

        gravityEngineInitializationThread(initText).start();

    }

    private Thread gravityEngineInitializationThread(BitmapText initText) {
        return new Thread(() -> {
            /*
             * when 60 frames per second: 60 sec * 1.0e+05 = 600 000 sec ~ 6.9444444 real days is 1 second of simulation for appSpeed = 1.0e+05
             */
            double appSpeed = 1.0e+05;
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunMercuryEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunMercuryVenusEarth().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunMercuryVenusEarthMars().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunMercuryVenusEarthMarsJupiter().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunMercuryVenusEarthMarsJupiterSaturn().setStepSize(appSpeed));
            this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.solarSystem().setStepSize(appSpeed));
//            this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.system3d().setStepSize(appSpeed));


//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.earthMoon().setStepSize(1.0));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.cEarthEcMoon().setStepSize(appSpeed));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunEarthMoon().setStepSize(10));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.biggerEarthAndSun());
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunBiggerEarthBiggerMoon());
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.earthSunWithSpeed(13.0));
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.abstractPlanet01AbstractPlane02Sun());
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.sunEarthBiggerVelocityMoonBiggerVelocity());
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.earthBiggerVelocitySun_AroundSun());
//        this.gravityEngine = getEngine(AstronomicalObjectSystemFactory.earthInCenterMoon());
//        this.gravityEngine = getEngine();
            gravityEngine.attachToNode(guiNode, envNode);

            isInitialized = true;
            guiNode.detachChild(initText);
//           TODO Here could be a problem if gui were not initialized
            Platform.runLater(() -> gravityEngine.getObjectViewList().forEach(x -> guiController.initializeObjButton(cam, x)));
        });
    }


    private AOSEngineWrapper getEngine(AstronomicalObjectSystem astronomicalObjectSystem) {
        List<AstronomicObjectView> astronomicObjects = AstronomicObjectViewFactory.toView(astronomicalObjectSystem, this.assetManager);
        return new AOSEngineWrapper(astronomicalObjectSystem, astronomicObjects);
    }


    private AOSEngineWrapper getEngine() {
        List<AstronomicObjectView> astronomicObjects = List.of(
                AstronomicObjectViewFactory.sun(assetManager),
                AstronomicObjectViewFactory.earth(assetManager)
        );
        return new AOSEngineWrapper(astronomicObjects);
    }


    private BitmapText showInitializationMessage() {
        BitmapText initText = new BitmapText(guiFont);
        initText.setSize(30);
        initText.setText("Wait, initialization...");
        initText.setColor(ColorRGBA.Red);
        initText.setLocalTranslation(cam.getWidth() / 2.0f, cam.getHeight() / 2.0f, 0f);
        guiNode.attachChild(initText);
        return initText;
    }

    private void initializeJavaFxGui() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui.fxml"));
            loader.setController(guiController);
            JavaFxUI.attachChild(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return gravityEngine.getAstronomicalObjectSystem().getStepSize();
    }

    public void setAppSpeed(double appSpeed) {
        gravityEngine.getAstronomicalObjectSystem().setStepSize(1.0 * Math.pow(10, appSpeed));
    }
}
