package dev.kirillzhelt.presenters.letter;

import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public interface LetterView {

    void rotateAll(Rotate rotate);
    void scaleAll(Scale scale);
    void translateX(Translate translate);

}
