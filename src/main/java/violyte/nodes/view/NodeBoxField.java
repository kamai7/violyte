package violyte.nodes.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class NodeBoxField extends BorderPane {
    private Label label;
    
    public NodeBoxField(String labelText) {
        label = new Label(labelText);
        setCenter(label);
        setStyle("-fx-border-color: gray; -fx-padding: 5;");
    }
}
