package violyte.nodes.view;

public class NodeBoxInput extends NodeBoxField {    
    public NodeBoxInput(String labelText) {
        super(labelText);
        /*DoubleBinding halfHeight = heightProperty().divide(2);
        
        getLabel().layoutXProperty().set(10);
        getLabel().layoutYProperty().bind(halfHeight);

        getHandle().layoutYProperty().bind(halfHeight);*/

        setLeftAnchor(getHandle(), -HANDLE_RADIUS);
        setLeftAnchor(getLabel(), 10.0);

        getHandle().getStyleClass().add("node-box-input-handle");
        getStyleClass().add("node-box-input");
    }
}
