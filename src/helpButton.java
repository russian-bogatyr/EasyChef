import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class helpButton extends Application {
	/**
	 * class for creating help button and main window
	 */
    public static void main(String[] args) {
        launch(args);
    }
    MenuItem helpButton;
    private int SCENE_WIDTH = 2000;
    private int SCENE_HEIGTH = 1000;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    	/**
    	 * creates stage primaryStage that holds buttons
    	 * & search bar
    	 */
    	primaryStage.setTitle("Main Window");
    	helpButton = new MenuItem();
        Pane root = new Pane();        
        Button helpButton = new Button();    
        helpButton.setTranslateX(960);
        helpButton.setTranslateY(865);   
        helpButton.setText("Help Button");
        
        helpButton.setOnAction(new EventHandler < ActionEvent >() {
        	/**
        	 * sets action for helpButton object,
        	 * which opens the helpWindow class object
        	 */
			public void handle (ActionEvent event) {				
				helpWindow HelpWindow = new helpWindow();
				try {
					HelpWindow.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    
			}
		});       
    	BackgroundImage myBI = new BackgroundImage(new Image("possiblebg1.jpg",2000,1000,false,true), 
    			BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
    			BackgroundSize.DEFAULT);
    	root.setBackground(new Background(myBI));
    	
    	Text title = new Text("EasyChef");
    	title.setFont(Font.font("Lucida Calligraphy",144));
    	title.setTranslateX(625);
    	title.setTranslateY(150);
    	
    	final Label label = new Label("Search");
        label.setFont(new Font("Arial", 20));

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        /**
         * choice box for the search bar
         */
        choiceBox.getItems().addAll("Recipe", "Time", "Rating");
        choiceBox.setValue("Recipe");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.setOnKeyReleased(keyEvent ->
        /**
         * different values for the search bar's
         * search options
         */
        {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Recipe":
                  
                    break;
                case "Time":
                   
                    break;
                case "Rating":
                   
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        /**
         * saves the value selected by the user for the choice box,
         * resets table and text field when choice is selected
         */
        {       		
            if (newVal != null)
            {
                textField.setText("");
                
            }
        });
        HBox hBox = new HBox(choiceBox, textField);//Add choiceBox and textField to hBox
        hBox.setAlignment(Pos.CENTER);//Center HBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setTranslateX(300);
        vbox.setTranslateY(300);
        vbox.getChildren().addAll(label, hBox);
        root.getChildren().addAll(vbox);
        Button sBar = new Button();    
        /**
         * button to initiate searching by ingredients,
         * opens new window
         */
        
        	sBar.setText("I have these ingredients:");
        
        	/**sBar.setOnAction(new EventHandler < ActionEvent >() 
        	/**
        	 * when help button is clicked,
        	 * help window pops up
        	 */
        	/*{
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
        sBar.setTranslateX(1350);
        sBar.setTranslateY(340);
        root.getChildren().addAll(sBar);
    	root.getChildren().add(title);
        root.getChildren().addAll(helpButton);
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGTH));
        primaryStage.show();
}
}