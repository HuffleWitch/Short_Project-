package src;

 /**
* Loader class loads a stage from a .json file selected by the user from a popup menu
 */
import java.awt.Desktop;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.WritableImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javax.imageio.ImageIO;
//import javax.json.Json;
//import javax.json.JsonReader;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class Loader
{
    FileChooser filechooser;
    Stage stage;
    Desktop desktop = Desktop.getDesktop();
    
    public Loader(Stage s)
    {
        filechooser = new FileChooser();
        stage =s;
    }
 
    private File chooseFile(Stage stage)
    {
        filechooser.setTitle("Open File");
        File file =filechooser.showOpenDialog(stage);
        return file;
    }
    
    private ArrayList[] convert(File file)
    {
        Gson gson = new Gson();
        ArrayList[] output = new ArrayList[2];
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        ArrayList<Shape> text = new ArrayList<Shape>();
        
        
        System.out.println(output);
        
        //output[0]=shapes;
        //output[1]=text;
        return output;
        
    }
    
    public Image importLoad(double width, double height)
    {
        File file = chooseFile(stage);
        Image image = new Image(file.toURI().toString(), width, height, true, false);
        return image;
    }
    
    public ArrayList[] load()
    {
        File file = this.chooseFile(stage);
        ArrayList[] loaded = convert(file);
        return loaded;
    }
}