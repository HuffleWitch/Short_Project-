

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
    public boolean isInHitBox(double isX, double isY) {
        double centerX = x + width/2;
        double centerY = y + height/2;
        if(centerX - width/2 < isX && isX < width/2 + centerX && centerY - height/2 < isY && isY < height/2 + centerY){
            return true;
        }
        else{
            return false;
        }
    }
    public void move(double deltaX, double deltaY){
        x += deltaX;
        y += deltaY;
    }
}
