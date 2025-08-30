package violyte;

import java.util.ArrayList;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import violyte.nodes.controler.NodeEditorControler;
import violyte.nodes.model.Node;
import violyte.nodes.model.NodeInput;
import violyte.nodes.view.NodeBox;
import violyte.nodes.view.NodeBoxInput;
import violyte.nodes.view.NodeBoxOutput;
import violyte.nodes.view.NodeEditorView;

/**
 * Hello world!
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Violyte");

        NodeEditorView editorView = new NodeEditorView();
        NodeEditorControler editorCtrl = new NodeEditorControler(editorView, Set.of(new MyNode()));
        primaryStage.setScene(new Scene(editorView, 800, 600));
        primaryStage.show();

        NodeBox node1 = new NodeBox("Node 1");
        node1.setLayoutX(200);
        node1.setLayoutY(100);
        node1.addField(new NodeBoxInput("Input 1"));
        node1.addField(new NodeBoxOutput("Output 1"));
        editorCtrl.addNode(node1);

        NodeBox node2 = new NodeBox("Node 2");
        node2.setLayoutX(400);
        node2.setLayoutY(200);
        node2.addField(new NodeBoxInput("Input 2"));
        node2.addField(new NodeBoxOutput("Output 2"));
        editorCtrl.addNode(node2);

        editorCtrl.addNode(new MyNode());
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class MyNode extends Node<Integer> {
        private NodeInput<Integer> input1 = new NodeInput<>("A");
        private NodeInput<Integer> input2 = new NodeInput<>("B");

        @Override
        public String getLabel() {
            return "My Node";
        }

        @Override
        public NodeInput<?>[] getInputs() {
            return new NodeInput[]{input1, input2};
        }

        @Override
        public Integer execute() {
            return input1.getValue() + input2.getValue();
        }
    } 
}
