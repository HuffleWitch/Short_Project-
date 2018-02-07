import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class HeronPaint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HeronPaint");
        Group root = new Group();
        Scene s = new Scene(root, 300, 300, Color.WHITE);

        final Canvas canvas = new Canvas(250,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(75,75,100,100);

        root.getChildren().add(canvas);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
