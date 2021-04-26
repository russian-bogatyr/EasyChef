import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainWindow extends Application {
	/**
	 * class for creating help button and main window
	 * @param helpButton
	 */
   /* public static void main(String[] args) {
        launch(args);
    }*/
    MenuItem helpButton;
    private int SCENE_WIDTH = 2000;
    private int SCENE_HEIGTH = 1000;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    	/**
    	 * creates stage primaryStage that holds buttons
    	 * & search bar
    	 * @param searchBar
    	 */
        primaryStage.setTitle("EasyChef");
        helpButton = new MenuItem();
        Pane root = new Pane();        
        Button helpButton = new Button();    
        helpButton.setTranslateX(980);
        helpButton.setTranslateY(865);   
        helpButton.setText("Help");
        
      
        
        helpButton.setOnAction(new EventHandler < ActionEvent >() {
        	/**
        	 * sets action for helpButton object,
        	 * which opens the helpWindow class object
        	 * @param helpButton Action
        	 * @return helpWindow
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
		 * 
		 * @return ChoiceBox
		 */
		choiceBox.getItems().addAll("Recipe", "Time", "Rating");
		choiceBox.setValue("Recipe");
		TextField textField = new TextField();
		textField.setPromptText("Search here!");

		textField.setOnAction(ENTER ->
		/**
		 * different values for the search bar's search options
		 */

		{
			String input = textField.getText();
			switch (choiceBox.getValue())// Switch on choiceBox value
			{
			case "Recipe":
				SearchRecipe(input);
				break;
			case "Time":
				try {
					SearchTime(input);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Rating":
				SearchRating(input);
				break;

			}
		});
		choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
		/**
		 * saves the value selected by the user for the choice box, resets table and
		 * text field when choice is selected
		 */
		{
			if (newVal != null) {
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
         * @param sBar
         * @return searchPop
         */
        
        	sBar.setText("I have these ingredients:");
        
        	sBar.setOnAction(new EventHandler < ActionEvent >() 
        	/**
        	 * when help button is clicked,
        	 * help window pops up
        	 */
        	{
        		public void handle (ActionEvent event) 
        		{				
        			checkBoxes checkBoxWindow = new checkBoxes();
        			try 
        			{
        				checkBoxWindow.start(checkBoxes.newStage);
        			} 
				
        			catch (Exception e) 
        			{
        				e.printStackTrace();
        			}			    
        		}
        	});       
        sBar.setTranslateX(1350);
        sBar.setTranslateY(340);
        root.getChildren().addAll(sBar);
    	root.getChildren().add(title);
        root.getChildren().addAll(helpButton);
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGTH));
        primaryStage.setX(primaryStage.getX() - 810);        // make main window to pop up in wide screen format
        primaryStage.setY(primaryStage.getY() - 280);
        primaryStage.show();
        
        
}
    public void SearchRecipe(String searchInput) {
    	/**
    	 * search algorithm for the recipes
    	 * @param recipeDirpath
    	 * @return recipeStage
    	 */
		Stage stageR = new Stage();
		TilePane paneR = new TilePane();
		String recipeDirpath = "C:/Users/nl/eclipse-workspace/finalEasyChef/Recipes";

		File recipeDir = new File(recipeDirpath);
		if (recipeDir.exists() && recipeDir.isDirectory()) {
			// array for files and sub-directories of directory pointed by recipe directory
			File[] arr = recipeDir.listFiles();
			
			//ArrayList<String> files = new ArrayList<String>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].getName().contains(searchInput)) {
					File s = new File(arr[i].getAbsolutePath());
					Button buttonR = new Button(arr[i].getAbsolutePath());
					paneR.getChildren().add(buttonR);
					buttonR.setOnAction(new EventHandler<ActionEvent>()

					{

						@Override

						public void handle(ActionEvent args) {
							Stage recipeStage = new Stage();
							TilePane flow = new TilePane();

							try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
								String lines;
								while ((lines = reader.readLine()) != null) {
									Label label = new Label(lines);
									flow.getChildren().add(label);
								}

							} catch (IOException e) {
								e.printStackTrace();
							}

							Scene recipeScene = new Scene(flow, 2000, 1000);
							recipeStage.setScene(recipeScene);
							recipeStage.show();
						}

					});

				}

			}
			paneR.setHgap(20);
			paneR.setVgap(20);
			Scene sceneR = new Scene(paneR, 500, 800);
			stageR.setScene(sceneR);
			stageR.show();
		}

	}

	public void SearchTime(String searchInput) throws IOException {
		/**
		 * search algorithm for the time section of
		 * search bar
		 * @param searchInput for time
		 * @return stageT, timeDir
		 */
		Stage stageT = new Stage();
		TilePane paneT = new TilePane();
		String timeDirpath = "C:/Users/nl/eclipse-workspace/finalEasyChef/Recipes";

		File timeDir = new File(timeDirpath);
		if (timeDir.exists() && timeDir.isDirectory()) {
			// array for files and sub-directories of directory pointed by recipe directory
			File[] arr = timeDir.listFiles();
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].getName().contains(searchInput)) {
					File s = new File(arr[i].getAbsolutePath());
					Button buttonT = new Button(arr[i].getAbsolutePath());
					paneT.getChildren().add(buttonT);
					buttonT.setOnAction(new EventHandler<ActionEvent>()

					{

						@Override

						public void handle(ActionEvent args) {
							Stage timeStage = new Stage();
							TilePane flow = new TilePane();

							try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
								String lines;
								while ((lines = reader.readLine()) != null) {
									Label label = new Label(lines);
									flow.getChildren().add(label);
								}

							} catch (IOException e) {
								e.printStackTrace();
							}

							Scene timeScene = new Scene(flow, 2000, 1000);
							timeStage.setScene(timeScene);
							timeStage.show();
						}

					});

				}

			}
			paneT.setHgap(20);
			paneT.setVgap(20);
			Scene sceneT = new Scene(paneT, 500, 800);
			stageT.setScene(sceneT);
			stageT.show();
		}

	}

	public void SearchRating(String searchInput) {
		//rating search algorithm here. 
	}
}
