package src;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Shape {

    private GraphicsContext gc;
    private Color color;

    public Shape(GraphicsContext gcon, Color c) {
        gc = gcon;
        color = c;
        gc.setStroke(c);
        gc.setFill(c);

    }

    public void draw(){}
}
