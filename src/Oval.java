
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class Oval implements Shape {

    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private double x2;
    private double x1;
    private double y1;
    private double y2;
    private boolean isCircle;

    public Oval(GraphicsContext gcon, Color c, double t, double xC1, double xC2, double yC1, double yC2, boolean ic) {
        gc = gcon;
        color = c;
        thicc = t;
        isCircle=ic;
        x1=xC1;
        x2=xC2;
        y1=yC1;
        y2=yC2;
    }

    public void draw() {
        //set color, width, etc for use later
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);
        //calculate width and height
        double h=y2-y1;
        double w=x2-x1;

        //draw
        if (isCircle){
            gc.strokeOval(x1,y1,w,w);
        }
        else{
            gc.strokeOval(x1,y1,w,h);
        }

    }

    public boolean isInHitBox(double isX, double isY) {
        if (isCircle) {
            double w=x2-x1;
            double centerX = x1 + w/2;
            double centerY = y1 + w/2;
            double dx = isX - centerX;
            double dy = isY - centerY;
            double dist = java.lang.Math.sqrt((dx*dx)+(dy*dy));
            return (dist < w/2);
        } else{
            boolean betweenX = (x1 < isX && isX < x2);
            boolean betweenY = (y1 < isY && isY < y2);
            return (betweenX && betweenY);
        }
    }
    public void move(double deltaX, double deltaY){
        x1 += deltaX;
        x2 += deltaX;
        y1 += deltaY;
        y2 += deltaY;
    }

}
