package dev.kirillzhelt.viewcontrollers.letter;

import dev.kirillzhelt.meshes.MeshViewUtils;
import dev.kirillzhelt.meshes.ZLetterMesh;
import dev.kirillzhelt.presenters.letter.LetterPresenter;
import dev.kirillzhelt.presenters.letter.LetterView;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.MatrixType;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

import java.text.DecimalFormat;

public class LetterViewController implements LetterView {

    @FXML
    private GridPane gridPane;
    private Group mainGroup;
    private TextArea transformationMatrixTextArea;

    private LetterPresenter presenter;

    public void init() {
        this.presenter = new LetterPresenter(this);

        this.gridPane.setHgap(20);

        this.setupColumns();

        this.mainGroup = new Group();
        this.gridPane.add(this.mainGroup, 0, 0);

        this.transformationMatrixTextArea = ControlUtils.createReadonlyTextArea(120, 100);
        this.gridPane.add(this.transformationMatrixTextArea, 1, 0);

        this.addLetterMeshView();

        this.setupKeyEventHandlers();
    }

    private void setupColumns() {
        this.gridPane.getColumnConstraints().clear();

        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(70, HPos.CENTER));
        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(25, HPos.RIGHT));
        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(5, HPos.CENTER));
    }

    private void addLetterMeshView() {
        ZLetterMesh letterMesh = new ZLetterMesh(100, 130);
        MeshView letterMeshView = MeshViewUtils.createMeshView(letterMesh.getMesh());

        this.mainGroup.getChildren().add(letterMeshView);
    }

    private void setupKeyEventHandlers() {
        this.gridPane.requestFocus();
        this.gridPane.addEventHandler(KeyEvent.KEY_PRESSED, (e) -> {
            switch (e.getCode()) {
                case UP: {
                    this.presenter.onKeyUpPressed();
                    break;
                }
                case DOWN: {
                    this.presenter.onKeyDownPressed();
                    break;
                }
                case RIGHT: {
                    this.presenter.onKeyRightPressed();
                    break;
                }
                case LEFT: {
                    this.presenter.onKeyLeftPressed();
                    break;
                }
                case Z: {
                    this.presenter.onKeyZPressed();
                    break;
                }
                case X: {
                    this.presenter.onKeyXPressed();
                    break;
                }
            }

        });
    }

    @Override
    public void rotateAll(Rotate rotate) {
        this.transform(rotate);
    }

    @Override
    public void scaleAll(Scale scale) {
        this.transform(scale);
    }

    private void transform(Transform transform) {
        this.mainGroup.getTransforms().add(transform);
        this.showTransformationMatrix(transform);
    }

    private void showTransformationMatrix(Transform transform) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder matrix = new StringBuilder();

        matrix
            .append(transform.getClass().getSimpleName())
            .append(": \n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix
                    .append(decimalFormat.format(transform.getElement(MatrixType.MT_3D_3x4, i, j)))
                    .append(" ");
            }
            matrix.append("\n");
        }

        this.transformationMatrixTextArea.setText(matrix.toString());
    }
}
