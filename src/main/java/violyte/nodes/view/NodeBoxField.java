package violyte.nodes.view;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * A base class for node box fields, providing a label and centering its children vertically.
 */
public abstract class NodeBoxField extends AnchorPane {
    public static final double HANDLE_RADIUS = 4.5;
    private Label label;
    private Circle handleCircle;
    private NodeWire wire;
    
    public NodeBoxField(String labelText) {
        label = new Label(labelText);
        handleCircle = new Circle(HANDLE_RADIUS);

        handleCircle.getStyleClass().add("node-box-handle");

        getChildren().addAll(label, handleCircle);
        getStyleClass().add("node-box-field");
    }

    /*@Override
    protected void layoutChildren() {
        double height = getHeight();
        for (Node child : getChildren()) {
            double childWidth = child.prefWidth(-1);
            double childHeight = child.prefHeight(-1);
            double x = child.getLayoutX();
            double y = (height - childHeight) / 2;
            child.resizeRelocate(x, y, childWidth, childHeight);
        }
    }*/

    public Label getLabel() {
        return label;
    }

    public Circle getHandle() {
        return handleCircle;
    }

    public NodeWire getWire() {
        return wire;
    }

    public void setWire(NodeWire wire) {
        this.wire = wire;
    }
}
