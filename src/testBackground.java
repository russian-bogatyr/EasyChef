import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class testBackground extends Application {
	/**
	 * code for creating a test main window
	 * with a custom background
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
@Override
public void start(Stage primaryStage) {
	StackPane root = new StackPane();
	root.setId("pane");
	Scene scene = new Scene(root, 2000, 1000);
	BackgroundImage myBI = new BackgroundImage(new Image("possiblebg1.jpg",2000,1000,false,true), 
			BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			BackgroundSize.DEFAULT);
	root.setBackground(new Background(myBI));
	primaryStage.setTitle("Main Window");
	Text title = new Text("EasyChef");
	title.setFont(Font.font("Palatino Linotype",144));
	StackPane.setAlignment(title, Pos.TOP_CENTER);
	root.getChildren().add(title);
	primaryStage.setScene(scene);
	primaryStage.show();
	
}
}	