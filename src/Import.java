package src;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;

public class Import implements Shape {

    private GraphicsContext gc;
    private double x;
    private double y;
    private String loc;

    public Import(GraphicsContext gcon, double xVal, double yVal, String imageLoc) {
        gc = gcon;
        x = xVal;
        y = yVal;
        loc = imageLoc;
    }

    public void draw() {
        Image im = new Image(loc);
        gc.drawImage(im,x,y);
    }
}
