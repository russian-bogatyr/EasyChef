import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class bar1 extends Application
{
	public static void main(String[] args)
	{
        launch(args);
    }
	
	public MenuItem searchB;
	
	@Override
    public void start(Stage primaryStage) throws Exception
    {
		/**
		 * code for creating ingredients'
		 * search button and put into
		 * test window
		 */
		primaryStage.setTitle("Test");
        searchB = new MenuItem();
        Pane root = new Pane();        
        Button sBar = new Button();    
        
        //Figure out placement here
        
        sBar.setText("I have these ingredients:");
        
        /**sBar.setOnAction(new EventHandler < ActionEvent >() 
        {
			public void handle (ActionEvent event) 
			{				
				searchPop HelpWindow = new searchPop();
				try 
				{
					HelpWindow.start(primaryStage);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}			    
			}
		}); */      
        
        root.getChildren().addAll(sBar);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

