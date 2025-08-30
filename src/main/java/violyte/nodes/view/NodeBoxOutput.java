package violyte.nodes.view;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeBoxOutput extends NodeBoxField {
    private Circle circle;
    private NodeWire wire;
    
    public NodeBoxOutput(String labelText) {
        super(labelText);
        
        circle = new Circle(5);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        setRight(circle);
        setMargin(circle, new Insets(0, 0, 0, 5));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setWire(NodeWire wire) {
        this.wire = wire;
    }
}
