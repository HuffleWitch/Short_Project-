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

public class HeronPaint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HeronPaint");
        BorderPane root = new BorderPane();
        Scene s = new Scene(root, 500, 500, Color.WHITE);

        final Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(-25,75,700,100);

        HBox toolBar = new HBox(
            new Button("New"),
            new Button("Open"),
            new Button("Save"),
            new Separator(Orientation.VERTICAL),
            new Button("Clean"),
            new Button("Compile"),
            new Button("Run"),
            new Separator(Orientation.VERTICAL),
            new Button("Debug"),
            new Button("Profile")
        );

        HBox toolBar2 = new HBox(
            new Button("New2"),
            new Button("Open"),
            new Button("Save"),
            new Separator(Orientation.VERTICAL),
            new Button("Clean"),
            new Button("Compile"),
            new Button("Run"),
            new Separator(Orientation.VERTICAL),
            new Button("Debug"),
            new Button("Profile")
        );

        VBox vbox = new VBox();
        vbox.getChildren().add(toolBar);
        vbox.getChildren().add(toolBar2);

        root.setCenter(canvas);
        root.setTop(vbox);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
