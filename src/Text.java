//text
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Text implements Shape {

    private GraphicsContext gc;
    private Color color;
    private String t;
    private double x;
    private double y;
    private boolean hidden;

    public Text(GraphicsContext gcon, Color c, double xVal, double yVal, String text){
        gc = gcon;
        color = c;        
        x = xVal;
        y = yVal;
        t = text;
        hidden = false;
    }

    public void draw() {
    	if(!hidden){
    		gc.setStroke(color);
        	gc.strokeText(t,x,y);
    	}
    }

    public boolean isHidden(){
    	if(hidden){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public void hide(){
    	hidden=true;
    }

    public void unhide(){
    	hidden=false;
    }


}
