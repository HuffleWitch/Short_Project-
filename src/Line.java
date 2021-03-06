

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class Line implements Shape
{
    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    public Line(GraphicsContext gcon, Color c, double t, double x, double y, double tempx2, double tempy2) {
        gc = gcon;
        color = c;
        thicc = t;
        x1 = x;
        y1 = y;
        x2 = tempx2;
        y2 = tempy2;
    }
    public void draw() {
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);
        gc.strokeLine(x1,y1,x2,y2);
    }
    public boolean isInHitBox(double isX, double isY){
        double mathy1 = -y1;
        double mathy2 = -y2;
        double m = (mathy1 - mathy2)/(x1-x2);
        double b = mathy1 - (m * x1);
        double result = (m*isX) + b;
        //System.out.println(isX+" "+ isY+" "+ m+" "+ b+" "+ result);
        return (result - 10 < -isY && -isY < result+10 );
    }
    public void move(double deltaX, double deltaY) {
        x1 += deltaX;
        x2 += deltaX;
        y1 += deltaY;
        y2 += deltaY;
    }
}
