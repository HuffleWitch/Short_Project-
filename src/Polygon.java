package src;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class Polygon implements Shape
{
    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private double[] xPoints;
    private double[] yPoints;
    private int nPoints;
    public Polygon(GraphicsContext gcon, Color c, double t, double[] x1points, double[] y1points, int npoints) {
        gc = gcon;
        color = c;
        thicc = t;
        xPoints = x1points;
        yPoints = y1points;
        nPoints = npoints;
    }
    public void draw() {
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);
        gc.strokePolygon(xPoints, yPoints, nPoints);
    }
}
