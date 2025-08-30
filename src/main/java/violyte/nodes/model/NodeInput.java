package violyte.nodes.model;

public class NodeInput<T> {
    private String label;
    private T value;

    public NodeInput(String label, T value) {
        this.label = label;
    }

    public NodeInput(String label) {
        this(label, null);
    }

    public String getLabel() {
        return label;
    }
    
    public T getValue() {
        return value;
    }
}
