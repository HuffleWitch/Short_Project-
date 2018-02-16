package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.image.Image;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.geometry.Orientation;
import javafx.scene.control.ButtonBar;
import java.util.ArrayList;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import javafx.print.*;
import javafx.print.Printer;
import javafx.scene.transform.Scale;
import javafx.scene.image.*;
import javafx.scene.control.Tooltip;

import java.lang.Class;


public class HeronPaint extends Application {

    // Main just launches the app by callibg launch which calls start
    public static void main(String[] args) {
        launch(args);
    }

    // Width and Height of Window/Canvas
    private int width = 800;
    private int height = 600;

    // General color variable
    private Color color = Color.BLACK;

    // Penstroke thicc-ness
    private double thicc = 1;

    // List of Shapes to draw
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private ArrayList<Shape> text = new ArrayList<Shape>();

    final Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Erases everything then redraws everything in shapes list
    private void refresh() {
        // I see a canvas and I want to paint it white
        System.out.println("Refreshing!");
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, width, height);

        // But then I redraw all the stuff in shapes
        for (Shape s: shapes) {
            s.draw();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HeronPaint");
        BorderPane root = new BorderPane();
        Scene s = new Scene(root, width, height);//, Color.WHITE);


        

        // All the color buttons
        Button whiteButton = new Button("", new Rectangle(20, 20, Color.WHITE));
        whiteButton.setTooltip(new Tooltip("White"));
        Button redButton = new Button("", new Rectangle(20, 20, Color.MISTYROSE));
        redButton.setTooltip(new Tooltip("Misty Rose"));
        Button yellowButton = new Button("", new Rectangle(20, 20, Color.ROSYBROWN));
        yellowButton.setTooltip(new Tooltip("Rosy Brown"));
        Button blueButton = new Button("", new Rectangle(20, 20, Color.CYAN));
        blueButton.setTooltip(new Tooltip("Cyan"));
        Button blackButton = new Button("", new Rectangle(20, 20, Color.CHARTREUSE));
        blackButton.setTooltip(new Tooltip("Chartreuse"));
        Button orangeButton = new Button("", new Rectangle(20, 20, Color.TOMATO));
        orangeButton.setTooltip(new Tooltip("Tomato"));
        Button greenButton = new Button("", new Rectangle(20, 20, Color.SLATEBLUE));
        greenButton.setTooltip(new Tooltip("Slate Blue"));
        Button purpleButton = new Button("", new Rectangle(20, 20, Color.DARKORCHID));
        purpleButton.setTooltip(new Tooltip("Dark Orchid"));
        
        

        whiteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.WHITE;
            }
        });
        redButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.MISTYROSE;
            }
        });
        yellowButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.ROSYBROWN;
            }
        });
        blueButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.CYAN;
            }
        });
        blackButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.CHARTREUSE;
            }
        });
        orangeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.TOMATO;
            }
        });
        greenButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.SLATEBLUE;
            }
        });
        purpleButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.DARKORCHID;
            }
        });

        // Thickness buttons
        Button penSize1 = new Button("", new Circle(1,Color.BLACK));
        penSize1.setTooltip(new Tooltip("Pen Small"));
        Button penSize5 = new Button("", new Circle(2.5,Color.BLACK));
        penSize5.setTooltip(new Tooltip("Pen Medium"));
        Button penSize10 = new Button("", new Circle(5,Color.BLACK));
        penSize10.setTooltip(new Tooltip("Pen Big"));

        penSize1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                thicc = 1;
            }
        });
        penSize5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                thicc = 5;
            }
        });
        penSize10.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                thicc = 10;
            }
        });
        //Button Images
        

        // All the other buttons

        Image penIcon = new Image("PenIcon.jpg", 20, 20, true, false);
        ImageView penImg = new ImageView();
        penImg.setImage(penIcon);
        Button penButton = new Button("", penImg);
        penButton.setTooltip(new Tooltip("Pen"));
        
        Image eraserIcon = new Image("EraserIcon.png", 20, 20, true, false);
        ImageView eraser = new ImageView();
        eraser.setImage(eraserIcon);
        Button eraseButton = new Button("", eraser);
        eraseButton.setTooltip(new Tooltip("Erase"));

        Image CursorIcon = new Image("CursorIcon.png", 20, 20, true, false);
        ImageView Curse = new ImageView();
        Curse.setImage(CursorIcon);
        Button selectButton = new Button("", Curse);
        selectButton.setTooltip(new Tooltip("Select"));
        Button lineButton = new Button("LINE");
        lineButton.setTooltip(new Tooltip("Line"));
        Button arcButton = new Button("ARC");
        arcButton.setTooltip(new Tooltip("Arc"));
        Button ovalButton = new Button("OVAL");
        Button rectButton = new Button("RECTANGLE");
        rectButton.setTooltip(new Tooltip("Rectangle"));
        Button circButton = new Button("CIRCLE");
        circButton.setTooltip(new Tooltip("Circle"));
        Button polyButton = new Button("POLYGON");
        polyButton.setTooltip(new Tooltip("Polygon"));
        Button textButton = new Button("TEXT");
        textButton.setTooltip(new Tooltip("Text"));
        Button noteButton = new Button("NOTE");
        noteButton.setTooltip(new Tooltip("Note"));
        Button hideButton = new Button("HIDE NOTES");
        hideButton.setTooltip(new Tooltip("Hide Notes"));
        Button importButton = new Button("IMPORT");
        importButton.setTooltip(new Tooltip("Import"));
        Button saveButton = new Button("SAVE");
        saveButton.setTooltip(new Tooltip("Save"));
        Button loadButton = new Button("LOAD");
        loadButton.setTooltip(new Tooltip("Load"));

        Image printicon = new Image("PrinterIcon.png", 20, 20, true, false);
        ImageView img = new ImageView();
        img.setImage(printicon);
        Button printButton = new Button("", img);
        printButton.setTooltip(new Tooltip("Print"));
        Button exportButton = new Button("EXPORT");
        exportButton.setTooltip(new Tooltip("Export"));

        EventHandler<MouseEvent> penHandler = new EventHandler<MouseEvent>() {
            double lastX = 0;
            double lastY = 0;
            ArrayList<Pair<Double,Double>> points = new ArrayList<Pair<Double,Double>>();
            public void handle(MouseEvent event) {
                //System.out.println(""+ event.getX()+" "+event.getY());
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    System.out.println("Mouse Pressed");
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                    gc.strokeLine(lastX, lastY, lastX, lastY);
                    points.add(new Pair<Double,Double>(lastX, lastY));

                }
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    System.out.println("Mouse Dragged");
                    gc.strokeLine(lastX, lastY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                    points.add(new Pair<Double,Double>(lastX, lastY));
                }
                if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("Mouse Released");
                    shapes.add(new Scribble(gc, color, thicc, points, false));
                    refresh();
                    points = new ArrayList<Pair<Double,Double>>();
                }
            }
        };

                 Stage stage = new Stage();
                 Saver saver = new Saver(primaryStage);
                 Loader loader = new Loader(stage);

                 ArrayList[] things= new ArrayList[2];
                 things[0]=shapes;
                 things[1]=text;

         saveButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {

                 saver.newSave(things);

            }
        });

        exportButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {

                 saver.saveAs(canvas);

            }
        });

        Loader l = new Loader(stage);
        importButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                 Image image = l.importLoad(width, height);
                 gc.drawImage(image, 0, 0);

            }
        });

        penButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(penHandler);

                canvas.setOnMouseDragged(penHandler);

                canvas.setOnMouseReleased(penHandler);

            }
        });

        EventHandler<MouseEvent> eraseHandler = new EventHandler<MouseEvent>() {
            double lastX = 0;
            double lastY = 0;
            ArrayList<Pair<Double,Double>> points = new ArrayList<Pair<Double,Double>>();
            public void handle(MouseEvent event) {
                //System.out.println(""+ event.getX()+" "+event.getY());
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    System.out.println("Mouse Pressed");
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                    gc.strokeLine(lastX, lastY, lastX, lastY);
                    points.add(new Pair<Double,Double>(lastX, lastY));

                }
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    System.out.println("Mouse Dragged");
                    gc.strokeLine(lastX, lastY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                    points.add(new Pair<Double,Double>(lastX, lastY));
                }
                if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("Mouse Released");
                    shapes.add(new Scribble(gc, Color.WHITE, thicc, points, true));
                    refresh();
                    points = new ArrayList<Pair<Double,Double>>();
                }
            }
        };

        eraseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(eraseHandler);

                canvas.setOnMouseDragged(eraseHandler);

                canvas.setOnMouseReleased(eraseHandler);

            }
        });

        // Implementing printing!
        printButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                Printer selectedPrinter = Printer.getDefaultPrinter();
                PageLayout pl = selectedPrinter.createPageLayout(Paper.NA_LETTER, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);

                Double pwidth = pl.getPrintableWidth();
                Double pheight = pl.getPrintableHeight();
                WritableImage wim = new WritableImage(pwidth.intValue(), pheight.intValue());

                // SnapShot Settings
                SnapshotParameters settings = new SnapshotParameters();
                settings.setTransform(new Scale((pwidth/width), (pwidth/width)));

                canvas.snapshot(settings, wim);
                ImageView iv = new ImageView();
                iv.setImage(wim);

                PrinterJob job = PrinterJob.createPrinterJob();
                job.setPrinter(selectedPrinter);
                if (job != null) {
                    //job.showPageSetupDialog(primaryStage);
                    boolean success = job.printPage(iv);
                    if (success) {
                        job.endJob();
                    }
                }

            }
        });

        // Line Button
        EventHandler<MouseEvent> lineHandler = new EventHandler<MouseEvent>()
        {
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                }
                if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("Mouse Released");
                    shapes.add(new Line(gc, color, thicc, lastX, lastY, event.getX(), event.getY()));
                    refresh();
                }
            }
        };

        lineButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(lineHandler);

                canvas.setOnMouseDragged(lineHandler);

                canvas.setOnMouseReleased(lineHandler);

            }
        });

        // Rect Button
        EventHandler<MouseEvent> rectHandler = new EventHandler<MouseEvent>()
        {
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                }
                if (event.getEventType() == MouseEvent.MOUSE_RELEASED)
                {
                    double xDiff = lastX - event.getX();
                    double yDiff = lastY - event.getY();
                    //4th quad
                    if(xDiff < 0 && yDiff < 0){
                        shapes.add(new OurRectangle(gc, color, thicc, lastX, lastY, Math.abs(xDiff), Math.abs(yDiff)));
                        refresh();
                    }
                    //3rd quad
                    if(xDiff > 0 && yDiff < 0){
                        shapes.add(new OurRectangle(gc, color, thicc, event.getX(), event.getY() + yDiff, xDiff, Math.abs(yDiff)));
                        refresh();
                    }
                    //2nd quad
                    if(xDiff > 0 && yDiff > 0){
                        shapes.add(new OurRectangle(gc, color, thicc, event.getX(), event.getY(), xDiff, yDiff));
                        refresh();
                    }
                    //1st quad
                    if(xDiff < 0 && yDiff > 0){
                        shapes.add(new OurRectangle(gc, color, thicc, event.getX() + xDiff, lastY - Math.abs(yDiff), Math.abs(xDiff), yDiff));
                        refresh();
                    }
                }
            }
        };

        EventHandler<MouseEvent> circHandler = new EventHandler<MouseEvent>(){
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                }
                if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
                    shapes.add(new Oval(gc,color,thicc, lastX, event.getX(), lastY, event.getY(), true));
                    refresh();
                    
                }
            }
        };
        
        EventHandler<MouseEvent> ovalHandler = new EventHandler<MouseEvent>(){
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                }
                if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
                    shapes.add(new Oval(gc,color,thicc, lastX, event.getX(), lastY, event.getY(), false));
                    refresh();
                    
                }
            }
        };
        
        EventHandler<MouseEvent> noteHandler = new EventHandler<MouseEvent>(){
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                }
                if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
                    //get text input through text field
                    if (event.getEventType() == KeyEvent().String ){iText = 
                    shapes.add(new Text(gc,color, lastX,lastY,iText));
                    refresh();
                }
            }
        };


        
        
        
        circButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                canvas.setOnMousePressed(circHandler);

                canvas.setOnMouseDragged(circHandler);

                canvas.setOnMouseReleased(circHandler);
            }
        
        });
        
        ovalButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                canvas.setOnMousePressed(ovalHandler);

                canvas.setOnMouseDragged(ovalHandler);

                canvas.setOnMouseReleased(ovalHandler);
            }
        });
        
        noteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(noteHandler);

                canvas.setOnMouseDragged(noteHandler);

                canvas.setOnMouseReleased(noteHandler);

            }
        });
        
        rectButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(rectHandler);

                canvas.setOnMouseDragged(rectHandler);

                canvas.setOnMouseReleased(rectHandler);

            }
        });
        
        importButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(importHandler);

                canvas.setOnMouseDragged(importHandler);

                canvas.setOnMouseReleased(importHandler);

            }
        });

        // Setting buttons in bars
        double spacing = 20;
        HBox thiccButtons = new HBox(penSize1,
                                     penSize5,
                                     penSize10);
        thiccButtons.setSpacing(spacing);
        thiccButtons.setAlignment(Pos.CENTER);

        HBox topButtons = new HBox();

        topButtons.getChildren().addAll(whiteButton,
                                        redButton,
                                        yellowButton,
                                        blueButton,
                                        penButton,
                                        selectButton,
                                        lineButton,
                                        polyButton,
                                        textButton,
                                        importButton,
                                        saveButton,
                                        printButton);

        topButtons.setSpacing(spacing);
        topButtons.setAlignment(Pos.CENTER);

        HBox botButtons = new HBox();

        botButtons.getChildren().addAll(blackButton,
                                        orangeButton,
                                        greenButton,
                                        purpleButton,
                                        eraseButton,
                                        ovalButton,
                                        rectButton,
                                        circButton,
                                        noteButton,
                                        hideButton,
                                        loadButton,
                                        exportButton);
        botButtons.setSpacing(spacing);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(topButtons, botButtons, thiccButtons);
        botButtons.setAlignment(Pos.CENTER);

        root.setCenter(canvas);
        root.setTop(vbox);
        primaryStage.setScene(s);
        refresh();
        primaryStage.show();
        penButton.fire();
    }
}
