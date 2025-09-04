package violyte.nodes.view;

import javafx.geometry.Pos;
import javafx.scene.shape.Circle;

public class NodeBoxInput extends NodeBoxField {
    
    private Circle inputCircle;

    public NodeBoxInput(String labelText) {
        super(labelText);

        inputCircle = new Circle(HANDLE_RADIUS);

        inputCircle.getStyleClass().add("node-box-handle");

        getChildren().add(inputCircle);

        setAlignment(inputCircle, Pos.CENTER_LEFT);
        inputCircle.setTranslateX(-HANDLE_RADIUS);

        getHandle().getStyleClass().add("node-box-input-handle");
        getStyleClass().add("node-box-input");
    }
}
