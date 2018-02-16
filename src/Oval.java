 
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

}
