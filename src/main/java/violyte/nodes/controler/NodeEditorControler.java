package violyte.nodes.controler;

import java.util.Set;

import org.controlsfx.control.SearchableComboBox;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import violyte.nodes.model.Node;
import violyte.nodes.model.NodeInput;
import violyte.nodes.view.NodeBox;
import violyte.nodes.view.NodeBoxInput;
import violyte.nodes.view.NodeBoxOutput;
import violyte.nodes.view.NodeEditorView;

public class NodeEditorControler {
    private NodeEditorView view;
    private Set<? extends Node<?>> nodeList;

    public NodeEditorControler(NodeEditorView view, Set<? extends Node<?>> nodeList) {
        this.view = view;
        this.nodeList = nodeList;

        // Initialize the searchable combo box with the list of available nodes
        view.getSearchBox().getItems().setAll(nodeList);

        // Set handlers for showing/hiding the add node menu
        view.getNodesPane().setOnMouseClicked(new ShowAddNodeHandler());
        view.getSearchBox().setOnHiding(new HideAddNodeHandler());
    }

    public void addNode(NodeBox nodeBox) {
        view.addNode(nodeBox);

        nodeBox.setOnMousePressed(new MoveNodeHandler(nodeBox));

        for (NodeBoxOutput output : nodeBox.getOutputs()) {
            output.getCircle().setOnDragDetected(new WireStartHandler(output));
        }

        for (NodeBoxInput input : nodeBox.getInputs()) {
            input.getCircle().setOnMouseDragReleased(new WireEndHandler(input));
        }
    }

    public void addNode(Node<?> node, double x, double y) {
        NodeBox nodeBox = new NodeBox(node.getLabel());
        for (NodeInput<?> input : node.getInputs()) {
            nodeBox.addField(new NodeBoxInput(input.getLabel()));
        }
        // TODO nodes with multiple outputs
        nodeBox.setLayoutX(x);
        nodeBox.setLayoutY(y);
        addNode(nodeBox);
    }

    public void addNode(Node<?> node) {
        this.addNode(node, 0, 0);
    }

    /**
     * Handlers for wire creation when starting drag on a node output.
     */
    private class WireStartHandler implements EventHandler<MouseEvent> {
        private NodeBoxOutput source;

        public WireStartHandler(NodeBoxOutput source) {
            this.source = source;
        }

        @Override
        public void handle(MouseEvent event) {
            source.startFullDrag();
            event.consume();
        }
    }

    /**
     * Handler for wire creation when releasing drag on a node input.
     */
    private class WireEndHandler implements EventHandler<MouseDragEvent> {
        private NodeBoxInput destination;

        public WireEndHandler(NodeBoxInput destination) {
            this.destination = destination;
        }

        public void handle(MouseDragEvent event) {
            Object source = event.getGestureSource();
            if (source instanceof NodeBoxOutput && source != null) {
                view.addWire((NodeBoxOutput) source, destination);
                event.consume();
            }
        }
    }

    /**
     * Handler for moving nodes when dragging them.
     */
    private class MoveNodeHandler implements EventHandler<MouseEvent> {
        private NodeBox nodeBox;

        public MoveNodeHandler(NodeBox nodeBox) {
            this.nodeBox = nodeBox;
        }

        public void handle(MouseEvent event) {
            
            double offsetX = event.getSceneX() - nodeBox.getLayoutX();
            double offsetY = event.getSceneY() - nodeBox.getLayoutY();

            nodeBox.setOnMouseDragged(ev -> {
                if (ev.getTarget() instanceof Circle) {
                    return;
                }
                nodeBox.setLayoutX(ev.getSceneX() - offsetX);
                nodeBox.setLayoutY(ev.getSceneY() - offsetY);
                ev.consume();
            });
        }
    }

    /**
     * Handler for double click to add a new node.
     */
    private class ShowAddNodeHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 2) {
                SearchableComboBox<? extends Node<?>> comboBox = view.getSearchBox();
                comboBox.setLayoutX(event.getX());
                comboBox.setLayoutY(event.getY());
                comboBox.setVisible(true);
                comboBox.show();
            }
        }
    }

    /**
     * Handler for hiding the add node menu, either when clicking outside of it or selecting a node.
     * If a node is selected, it is added to the editor at the position of the combo box.
     */
    private class HideAddNodeHandler implements EventHandler<Event> {
        public void handle(Event event) {
            view.getSearchBox().setVisible(false);

            SearchableComboBox<Node<?>> comboBox = view.getSearchBox();
            Node<?> selectedNode = comboBox.getSelectionModel().getSelectedItem();
            if (selectedNode != null) {
                addNode(selectedNode, comboBox.getLayoutX(), comboBox.getLayoutY());
            }
        }
    }
}
