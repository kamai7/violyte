package violyte.nodes.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * A base class for node box fields, providing a label and centering its children vertically.
 */
public abstract class NodeBoxField extends StackPane {

    public static final double HANDLE_RADIUS = 4.5;
    private Label label;
    
    public NodeBoxField(String labelText) {
        label = new Label(labelText);
        
        getStyleClass().add("node-box-field");
        setAlignment(label, Pos.CENTER);
    }

    public Label getLabel() {
        return label;
    }
}
