package violyte.nodes.view;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CenterYPane extends Pane {
    @Override
    protected void layoutChildren() {
        double height = getHeight();
        for (Node child : getChildren()) {
            double childWidth = child.prefWidth(-1);
            double childHeight = child.prefHeight(-1);
            double x = child.getLayoutX(); // Use setLayoutX() for free x positioning
            double y = (height - childHeight) / 2;
            child.resizeRelocate(x, y, childWidth, childHeight);
        }
    }
}