package dev.kirillzhelt.viewcontrollers.letter;

import javafx.geometry.HPos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;


public class ControlUtils {

    private ControlUtils() {}

    public static ColumnConstraints createColumn(double width, HPos alignment) {
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(width);
        column.setHalignment(alignment);
        return column;
    }

    public static TextArea createReadonlyTextArea(double width, double height) {
        TextArea textArea = new TextArea();
        textArea.setDisable(true);
        textArea.setMaxSize(width, height);
        return textArea;
    }

}
