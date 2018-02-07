import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public abstract class Shape {

    private GraphicsContext gc;
    private Color color;

    public Shape(GraphicsContext gcon, Color c) {
        gc = gcon;
        color = c;
    }

    public abstract void draw();

    public abstract void undraw();
}
