package violyte.nodes.view;

import javafx.geometry.Pos;
import javafx.scene.shape.Circle;

public class NodeBoxOutput extends NodeBoxField {

    private Circle outputCircle;
    
    public NodeBoxOutput(String labelText) {
        super(labelText);

        outputCircle = new Circle(HANDLE_RADIUS);

        outputCircle.getStyleClass().add("node-box-handle");

        getChildren().add(outputCircle);

        setAlignment(outputCircle, Pos.CENTER_LEFT);
        outputCircle.setTranslateX(HANDLE_RADIUS);

        getHandle().getStyleClass().add("node-box-input-handle");
        getStyleClass().add("node-box-input");
    }
}
