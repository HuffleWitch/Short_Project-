import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.geometry.Orientation;
import javafx.scene.control.ButtonBar;
import java.util.ArrayList;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

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

    final Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Erases everything then redraws everything in shapes list
    private void refresh() {
        // I see a canvas and I want to paint it white
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
        Button redButton = new Button("", new Rectangle(20, 20, Color.RED));
        Button yellowButton = new Button("", new Rectangle(20, 20, Color.YELLOW));
        Button blueButton = new Button("", new Rectangle(20, 20, Color.BLUE));
        Button blackButton = new Button("", new Rectangle(20, 20, Color.BLACK));
        Button orangeButton = new Button("", new Rectangle(20, 20, Color.ORANGE));
        Button greenButton = new Button("", new Rectangle(20, 20, Color.GREEN));
        Button purpleButton = new Button("", new Rectangle(20, 20, Color.PURPLE));

        whiteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.WHITE;
            }
        });
        redButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.RED;
            }
        });
        yellowButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.YELLOW;
            }
        });
        blueButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.BLUE;
            }
        });
        blackButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.BLACK;
            }
        });
        orangeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.ORANGE;
            }
        });
        greenButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.GREEN;
            }
        });
        purpleButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                color = Color.PURPLE;
            }
        });

        // Thickness buttons
        Button penSize1 = new Button("", new Circle(1,Color.BLACK));
        Button penSize5 = new Button("", new Circle(2.5,Color.BLACK));
        Button penSize10 = new Button("", new Circle(5,Color.BLACK));

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

        // All the other buttons
        Button penButton = new Button("PEN");
        Button eraseButton = new Button("ERASE");
        Button selectButton = new Button("SELECT");
        Button lineButton = new Button("LINE");
        Button arcButton = new Button("ARC");
        Button rectButton = new Button("RECTANGLE");
        Button circButton = new Button("CIRCLE");
        Button polyButton = new Button("POLYGON");
        Button textButton = new Button("TEXT");
        Button noteButton = new Button("NOTE");
        Button hideButton = new Button("HIDE NOTES");
        Button importButton = new Button("IMPORT");
        Button saveButton = new Button("SAVE");
        Button loadButton = new Button("LOAD");
        Button printButton = new Button("PRINT");

        EventHandler<MouseEvent> penHandler = new EventHandler<MouseEvent>() {
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                //System.out.println(""+ event.getX()+" "+event.getY());
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(color);
                    gc.setFill(color);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                    gc.strokeLine(lastX, lastY, lastX, lastY);

                }
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    gc.strokeLine(lastX, lastY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                }
            }
        };

        penButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(penHandler);

                canvas.setOnMouseDragged(penHandler);

            }
        });

        EventHandler<MouseEvent> eraseHandler = new EventHandler<MouseEvent>() {
            double lastX = 0;
            double lastY = 0;
            public void handle(MouseEvent event) {
                //System.out.println(""+ event.getX()+" "+event.getY());
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(thicc);
                    lastX = event.getX();
                    lastY = event.getY();
                    gc.strokeLine(lastX, lastY, lastX, lastY);

                }
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    gc.strokeLine(lastX, lastY, event.getX(), event.getY());
                    lastX = event.getX();
                    lastY = event.getY();
                }
            }
        };

        eraseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                canvas.setOnMousePressed(eraseHandler);

                canvas.setOnMouseDragged(eraseHandler);

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
                                        arcButton,
                                        rectButton,
                                        circButton,
                                        noteButton,
                                        hideButton,
                                        loadButton);
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
