package violyte.nodes.model;

/**
 * Abstract base class for all nodes.
 * A node is a processing unit that takes inputs, performs some computation, and produces outputs.
 * Each node has metadata that describes its inputs, outputs, and other properties.
 * @param <T> The type of the output produced by this node
 */
public abstract class Node<T> {
    /**
     * Retrieve the label of this node.
     * @return The label of this node
     */
    public abstract String getLabel();

    /**
     * Retrieve all the input fields of this node.
     * @return An array of input fields
     */
    public abstract NodeInput<?>[] getInputs();

    /**]
     * Execute the node's computation and return its output.
     * @return The output produced by this node
     */
    public abstract T execute();

    @Override
    public String toString() {
        return getLabel();
    }
}
