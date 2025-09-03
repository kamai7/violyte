package violyte.nodes.view;

import org.controlsfx.control.SearchableComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import violyte.nodes.model.Node;

public class NodeEditorView extends Pane {
    private Pane nodesPane;
    private Pane wiresPane;
    private SearchableComboBox<Node<?>> searchBox;
    
    public NodeEditorView(ObservableList<Node<?>> nodeList) {
        nodesPane = new Pane();
        wiresPane = new Pane();
        searchBox = new SearchableComboBox<>(nodeList);
        searchBox.setVisible(false);
        
        getChildren().addAll(wiresPane, nodesPane, searchBox);
        getStyleClass().add("node-editor");
    }

    public NodeEditorView() {
        this(FXCollections.observableArrayList());
    }

    public void addNode(NodeBox nodeBox) {
        nodesPane.getChildren().add(nodeBox);
    }

    public void addWire(NodeWire wire) {
        wiresPane.getChildren().add(wire);
    }

    public void addWire(NodeBoxOutput source, NodeBoxInput destination) {
        addWire(new NodeWire(source, destination));
    }

    public Pane getNodesPane() {
        return nodesPane;
    }

    public Pane getWiresPane() {
        return wiresPane;
    }

    public SearchableComboBox<Node<?>> getSearchBox() {
        return searchBox;
    }
}
