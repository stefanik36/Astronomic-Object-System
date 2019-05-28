package com.agh.aos.game;

import com.agh.aos.game.objects.AstronomicObjectView;
import com.jme3.renderer.Camera;

public class OnObjectCameraFocusHolder {

    private Camera camera;
    private AstronomicObjectView focusedTarget;
    private boolean lockCameraDirection = false;

    public OnObjectCameraFocusHolder(Camera camera) {
        this.camera = camera;
    }

    public void setFocusedTarget(AstronomicObjectView focusedView) {
        this.focusedTarget = focusedView;
    }

    public void focusOnTargetIfSet() {
        if (focusedTarget != null) {
            var vec = focusedTarget.focusCameraOn(camera);
            if (lockCameraDirection) {
                camera.lookAt(vec, camera.getUp());
                lockCameraDirection = false;
            }
        }
    }

    public boolean isLockCameraDirection() {
        return lockCameraDirection;
    }

    public void setLockCameraDirection(boolean lockCameraDirection) {
        this.lockCameraDirection = lockCameraDirection;
    }
}
