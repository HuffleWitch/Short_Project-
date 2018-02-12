package src;


/**
* Saver class newSave() saves an array containing two ArrayLists of objects (shapes and texts) to .json 
* file allowing the user to specify the new file name and location from within a popup menu - saveAs() 
* exports a snapshot of the canvas to a filetype selected by the user.
 */

import java.awt.Desktop;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class Saver
{
    FileChooser filechooser;
    Stage stage;
    public Saver(Stage s)
    {
        stage =s;
        filechooser = new FileChooser();
    }
    
    public void oldSave(ArrayList[] objects)
    {
    }

    public void newSave(ArrayList[] objects)
    {
        //Takes in the ArrayLists(Shapes and text) from Main and saves as An array of ArrayLists that are HeronPaint objects to a JSON file
        
        filechooser.setTitle("Save File");
        
        FileChooser.ExtensionFilter efilter = new FileChooser.ExtensionFilter("JSON","*.json");
        filechooser.getExtensionFilters().add(efilter);
        
        File file = filechooser.showSaveDialog(stage);
        
        Gson gson = new Gson();
        
        String savedObjects = gson.toJson(objects);
        
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(savedObjects);
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
          
    }
    
    public void saveAs(Canvas canvas)
    {
       
       filechooser.setTitle("Save File");
       
       filechooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("SVG Files(*.SVG)", "*.svg"),
            new FileChooser.ExtensionFilter("JPG Files(*.JPG)","*.jpg"),
            new FileChooser.ExtensionFilter("PNG Files(*PNG)","*.png"));
        
        File file = filechooser.showSaveDialog(stage);
        
        if(file!=null){
            String fileName=file.getName();
            String fileExt = "";
            int i = fileName.lastIndexOf('.');
            if(i>0 && i<fileName.length()){
                fileExt = fileName.substring(i+1);
            }
            //System.out.println(fileExt);
            try{
                WritableImage writeableImage = new WritableImage((int)(canvas.getWidth()),(int)(canvas.getHeight()));
                canvas.snapshot(null, writeableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writeableImage, null);
                ImageIO.write(renderedImage, fileExt, file);
            }
            catch(IOException ex){
                Logger.getLogger(HeronPaint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void rename(File file){
        
    }
}

