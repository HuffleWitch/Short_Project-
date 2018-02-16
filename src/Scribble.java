

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class Scribble implements Shape {

    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private ArrayList<Pair<Double,Double>> points;
    private boolean isErase;

    public Scribble(GraphicsContext gcon, Color c, double t, ArrayList<Pair<Double,Double>> ps, boolean erase) {
        gc = gcon;
        color = c;
        thicc = t;
        points = ps;
        isErase = erase;
    }

    public void draw() {
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);

        double x1 = points.get(0).getKey();
        double y1 = points.get(0).getValue();
        double x2 = points.get(0).getKey();
        double y2 = points.get(0).getKey();
        for (int i = 0; i < points.size(); i++) {
            x2 = points.get(i).getKey();
            y2 = points.get(i).getValue();

            gc.strokeLine(x1,y1,x2,y2);

            x1 = x2;
            y1 = y2;
        }
    }

    public boolean isEraseMark() {
        return isErase;
    }
    public boolean isInHitBox(double isX, double isY) {
        for (int i = 0; i < points.size(); i++) {
            //if(points.get(i).getKey() == isX && points.get(i).getValue() == isY){
            if(points.get(i).getKey() - 10 < isX && isX < 10 + points.get(i).getKey()
            && points.get(i).getValue() - 10 < isY && isY < 10 + points.get(i).getValue()){
                return true;
            }
        }
        return false;
    }
    public void move(double deltaX, double deltaY){
        for (int i = 0; i < points.size(); i++) {
            double newx = points.get(i).getKey() + deltaX;
            double newy = points.get(i).getValue() + deltaY;
            points.set(i, new Pair<Double,Double>(newx, newy));
        }
    }
}
