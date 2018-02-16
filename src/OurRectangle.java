

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class OurRectangle implements Shape
{
    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private double x;
    private double y;
    private double height;
    private double width;
    public OurRectangle(GraphicsContext gcon, Color c, double t, double tempx, double tempy, double tempwidth, double tempheight) {
        gc = gcon;
        color = c;
        thicc = t;
        x = tempx;
        y = tempy;
        height = tempheight;
        width = tempwidth;
    }
    public void draw() {
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);
        gc.strokeRect(x, y, width, height);
    }
    public void scale() {
        
    }
}

