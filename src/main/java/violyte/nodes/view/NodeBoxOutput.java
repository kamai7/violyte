package violyte.nodes.view;

public class NodeBoxOutput extends NodeBoxField {
    
    public NodeBoxOutput(String labelText) {
        super(labelText);
        /*DoubleBinding halfHeight = heightProperty().divide(2);
        
        getLabel().layoutXProperty().bind(
            widthProperty()
            .subtract(getLabel().widthProperty())
            .subtract(10)
        );
        getLabel().layoutYProperty().bind(halfHeight);
        
        getHandle().layoutXProperty().bind(widthProperty());
        getHandle().layoutYProperty().bind(halfHeight);*/

        setRightAnchor(getHandle(), -HANDLE_RADIUS);
        setRightAnchor(getLabel(), 10.0);

        getHandle().getStyleClass().add("node-box-input-handle");
        getStyleClass().add("node-box-input");
    }
}
