package dev.kirillzhelt;

import dev.kirillzhelt.meshes.ZLetterMesh;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private GridPane gridPane;

    public void init() {
        MeshView letterMeshView = new MeshView((new ZLetterMesh(100, 200)).getMesh());
        letterMeshView.setDrawMode(DrawMode.FILL);
        letterMeshView.setMaterial(new PhongMaterial());
        letterMeshView.setTranslateX(0);
        letterMeshView.setTranslateY(0);
        letterMeshView.setTranslateZ(-250);
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
