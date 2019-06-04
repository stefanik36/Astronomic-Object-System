package com.agh.aos.game.gui;

import com.agh.aos.game.Main;
import com.agh.aos.game.objects.AstronomicObjectView;
import com.jme3.renderer.Camera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    private Main main;
    @FXML
    VBox planetsManager;
    @FXML
    Slider flyCameraSpeedSlider;
    @FXML
    AnchorPane guiContainer;
    @FXML
    Slider simSpeedSlider;

    public GuiController(Main main) {
        this.main = main;
    }

    @FXML
    void resetCameraPosition(ActionEvent event) {
        main.startCameraPosition();
    }

    @FXML
    void lockCamDirection(ActionEvent event) {
        var man = main.getOnObjectCameraFocusHolder();
        man.setLockCameraDirection(true);
    }


    public void initializeObjButton(Camera cam, AstronomicObjectView view) {
        var btn = new ToggleButton(view.getAstronomicalObject().getName());
        btn.setOnAction(event -> {
            if (btn.isSelected()) {
                planetsManager.getChildren().stream()
                        .filter(x -> !x.equals(btn))
                        .filter(x -> x instanceof ToggleButton)
                        .map(x -> (ToggleButton) x)
                        .forEach(x -> x.setSelected(false));
                main.getOnObjectCameraFocusHolder().setFocusedTarget(view);
            } else {
                main.getOnObjectCameraFocusHolder().setFocusedTarget(null);
            }
        });
        planetsManager.getChildren().add(btn);
    }


    public void setVisible(boolean s) {
        guiContainer.setVisible(s);
    }

    public boolean isVisible() {
        return guiContainer.isVisible();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        flyCameraSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> main.getFlyByCamera().setMoveSpeed(newValue.floatValue()));

        simSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> main.setAppSpeed(newValue.doubleValue()));

    }
}
