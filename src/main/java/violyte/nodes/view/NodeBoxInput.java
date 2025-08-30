package violyte.nodes.view;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeBoxInput extends NodeBoxField {
    private Circle circle;
    private NodeWire wire;
    
    public NodeBoxInput(String labelText) {
        super(labelText);
        
        circle = new Circle(5);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        setLeft(circle);
        setMargin(circle, new Insets(0, 5, 0, 0));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setWire(NodeWire wire) {
        this.wire = wire;
    }
}
