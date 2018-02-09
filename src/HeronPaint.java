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
import javafx.scene.shape.Rectangle;

public class HeronPaint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HeronPaint");
        BorderPane root = new BorderPane();
        Scene s = new Scene(root, 1000, 800);//, Color.WHITE);

        final Canvas canvas = new Canvas(1000,800);
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

        // All the other buttons
        Button penButton = new Button("PEN");
        Button eraseButton = new Button("ERASE");
        Button selectButton = new Button("SELECT");
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

        ButtonBar topButtons = new ButtonBar();

        topButtons.getButtons().addAll(whiteButton,
                                    redButton,
                                    yellowButton,
                                    blueButton,
                                    penButton,
                                    selectButton,
                                    polyButton,
                                    textButton,
                                    importButton,
                                    saveButton,
                                    printButton);

        ButtonBar botButtons = new ButtonBar();

        botButtons.getButtons().addAll(blackButton,
                                     orangeButton,
                                     greenButton,
                                     purpleButton,
                                     eraseButton,
                                     rectButton,
                                     circButton,
                                     noteButton,
                                     hideButton,
                                     loadButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(topButtons, botButtons);

        root.setCenter(canvas);
        root.setTop(vbox);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
