import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class helpWindow extends Application {
	/**
	 * creating the help window that appears
	 * and the text inside it
	 * @param helpWindow
	 */
	private int SCENE_WIDTH = 1000;
    private int SCENE_HEIGTH = 700;
    public static Rectangle rectangle;
    public static Pane shapePane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		//ENTER HELP INSTRUCTIONS HERE LATER OMG
		 BackgroundImage helpBI = new BackgroundImage(new Image("helpwindowinstructions.png",1000,700,false,true), 
    			BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
    			BackgroundSize.DEFAULT);
		 Label secondLabel = new Label("");
         StackPane secondaryLayout = new StackPane();
         secondaryLayout.getChildren().add(secondLabel);
         Scene secondScene = new Scene(secondaryLayout, SCENE_WIDTH, SCENE_HEIGTH);
         
         Stage helpWindow = new Stage();
         secondaryLayout.setBackground(new Background(helpBI));
         helpWindow.setTitle("Help Window");
         helpWindow.setScene(secondScene);
         helpWindow.setX(primaryStage.getX() + 200);
         helpWindow.setY(primaryStage.getY() + 100);

         helpWindow.show();
	}
	

}