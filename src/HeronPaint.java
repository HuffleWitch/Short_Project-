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
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;

public class HeronPaint extends Application {

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        launch(args);
    }

    private Color color = Color.BLACK;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HeronPaint");
        BorderPane root = new BorderPane();
        Scene s = new Scene(root, 1050, 800);//, Color.WHITE);

        final Canvas canvas = new Canvas(1050,800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,100,100);

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

        penButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

            }
        });

        // Setting buttons in bars
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
        double spacing = 20;
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
        vbox.getChildren().addAll(topButtons, botButtons);
        botButtons.setAlignment(Pos.CENTER);

        root.setCenter(canvas);
        root.setTop(vbox);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
