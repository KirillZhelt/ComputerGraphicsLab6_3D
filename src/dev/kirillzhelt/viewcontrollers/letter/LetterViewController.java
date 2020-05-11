package dev.kirillzhelt.viewcontrollers.letter;

import dev.kirillzhelt.meshes.MeshViewUtils;
import dev.kirillzhelt.meshes.ZLetterMesh;
import dev.kirillzhelt.presenters.letter.LetterPresenter;
import dev.kirillzhelt.presenters.letter.LetterView;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.MeshView;

public class LetterViewController implements LetterView {

    @FXML
    private GridPane gridPane;

    private LetterPresenter presenter;

    public void init() {
        this.presenter = new LetterPresenter();

        this.addLetterMeshView();
    }

    private void addLetterMeshView() {
        ZLetterMesh letterMesh = new ZLetterMesh(100, 130);
        MeshView letterMeshView = MeshViewUtils.createMeshView(letterMesh.getMesh());

//
//        Rotate rotateY = new Rotate(60, 50, 30, 40);
//        rotateY.setAxis(Rotate.Y_AXIS);
//
//        letterMeshView.getTransforms().add(rotateY);
//
//        Rotate rotateX = new Rotate(30, 50, 30, 40);
//        rotateX.setAxis(Rotate.X_AXIS);

//        letterMeshView.getTransforms().add(rotateX);

        gridPane.getChildren().add(letterMeshView);
    }
}
