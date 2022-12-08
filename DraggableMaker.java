import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;

    public void makeDraggable(Node node){
        node.setOnMouseDragged(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX());
            node.setLayoutY(mouseEvent.getSceneY());
        });
    }
}
