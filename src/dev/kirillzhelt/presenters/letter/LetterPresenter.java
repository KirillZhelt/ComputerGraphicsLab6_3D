package dev.kirillzhelt.presenters.letter;

import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class LetterPresenter {

    private LetterView letterView;

    public LetterPresenter(LetterView letterView) {
        this.letterView = letterView;
    }

    public void onKeyUpPressed() {
        System.out.println("onKeyUpPressed");

        this.rotateView(15, Rotate.X_AXIS);
    }

    public void onKeyDownPressed() {
        System.out.println("onKeyDownPressed");

        this.rotateView(-15, Rotate.X_AXIS);
    }

    public void onKeyLeftPressed() {
        System.out.println("onKeyLeftPressed");

        this.rotateView(-15, Rotate.Y_AXIS);
    }

    public void onKeyRightPressed() {
        System.out.println("onKeyRightPressed");

        this.rotateView(15, Rotate.Y_AXIS);
    }

    private void rotateView(double angle, Point3D axis) {
        this.letterView.rotateAll(new Rotate(angle, 0, 0, 0, axis));
    }

    public void onKeyZPressed() {
        System.out.println("onKeyZPressed");

        this.scaleView(1 / 1.1);
    }

    public void onKeyXPressed() {
        System.out.println("onKeyXPressed");

        this.scaleView(1.1);
    }

    public void onKeyAPressed() {
        System.out.println("onKeyAPressed");

        this.translateXView(-10);
    }

    public void onKeySPressed() {
        System.out.println("onKeySPressed");

        this.translateXView(10);
    }

    public void translateXView(double translateValue) {
        this.letterView.translateX(new Translate(translateValue, 0, 0));
    }

    private void scaleView(double scaleFactor) {
        this.letterView.scaleAll(new Scale(scaleFactor, scaleFactor, scaleFactor, 0, 0, 0));
    }

}
