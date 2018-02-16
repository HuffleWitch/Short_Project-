

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
    public boolean isInHitBox(double x, double y){
        for (int i = 0; i < nPoints; i++) {
            if(xPoints[i] - 20 < x && x < xPoints[i] + 20 && yPoints[i] - 20 < y && y < 20 + yPoints[i]){
                return true;
            }
        }
        return false;
    }
    public void move(double deltaX, double deltaY){
        for(int i = 0; i < nPoints; i++){
            xPoints[i] += deltaX;
            yPoints[i] += deltaY;
        }
    }
}
