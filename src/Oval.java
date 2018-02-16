import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.util.ArrayList;
import javafx.util.Pair;

public class Oval implements Shape {

    private GraphicsContext gc;
    private Color color;
    private double thicc;
    private ArrayList<Pair<Double,Double>> points;
    private boolean isCircle;

    public Oval(GraphicsContext gcon, Color c, double t, ArrayList<Pair<Double,Double>> ps, boolean ic) {
        gc = gcon;
        color = c;
        thicc = t;
        points = ps;
        isCircle=ic;
    }

    public void draw() {
        //set color, width, etc for use later
        gc.setStroke(color);
        gc.setFill(color);
        gc.setLineWidth(thicc);
        //starting point
        double x1 = points.get(0).getKey();
        double y1 = points.get(0).getValue();
        double x2 = points.get(0).getValue();
        double y2 = points.get(0).getValue();
        //let user drag to get width and height
        for (int i = 1; i < points.size(); i++) {
            x2 = points.get(i).getKey();
            y2 = points.get(i).getValue();
            x1 = x2;
            y1 = y2;
        }
        //calculate width and height
        double h=y2-y1;
        double w=x2-x1;

        //draw
        if (isCircle){
            gc.strokeOval(x1,y1,(w+h)/2,(w+h)/2);
        }
        else{
            gc.strokeOval(x1,y1,w,h);
        }
        
    }

}
