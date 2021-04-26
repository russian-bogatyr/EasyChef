import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class checkBoxes extends Application
{
	ingredients ingredients = new ingredients();
	static Stage newStage = new Stage();
	static boolean chickenBoxSelected;
	static boolean beefBoxSelected;
	static boolean porkBoxSelected;
	static boolean noodlesBoxSelected;
	static boolean carrotsBoxSelected;
	static boolean potatoesBoxSelected;
	static boolean tomatoesBoxSelected;
	static boolean eggsBoxSelected;
	static boolean cheeseBoxSelected;
	static boolean sauceBoxSelected;

	public void start(Stage newStage) throws Exception
	{
		newStage.setTitle("I have these ingredients");
		
		//creating the checkboxes
		
		CheckBox chickenBox = new CheckBox("Chicken");
		CheckBox beefBox = new CheckBox("Beef");
		CheckBox porkBox = new CheckBox("Pork");
		CheckBox noodlesBox = new CheckBox("Noodles");
		CheckBox carrotsBox = new CheckBox("Carrots");
		CheckBox potatoesBox = new CheckBox("Potatoes");
		CheckBox tomatoesBox = new CheckBox("Tomatoes");
		CheckBox eggsBox = new CheckBox("Eggs");
		CheckBox cheeseBox = new CheckBox("Cheese");
		CheckBox sauceBox = new CheckBox("Sauce");
		

	    chickenBoxSelected = chickenBox.isSelected();
	    beefBoxSelected = beefBox.isSelected();
	    porkBoxSelected = porkBox.isSelected();
	    noodlesBoxSelected = noodlesBox.isSelected();
	    carrotsBoxSelected = carrotsBox.isSelected();
	    potatoesBoxSelected = potatoesBox.isSelected();
	    tomatoesBoxSelected = tomatoesBox.isSelected();
	    eggsBoxSelected = eggsBox.isSelected();
	    cheeseBoxSelected = cheeseBox.isSelected();
	    sauceBoxSelected = sauceBox.isSelected();
	    
		
		//putting all of the checkboxes on gridPane
		
		GridPane gridPane = new GridPane();
		Button searchButton = new Button();
		searchButton.setText("Filter");  //creating a filter button to search in regards to the food type
		
		
		gridPane.add(chickenBox, 0,  0, 2, 1);
		gridPane.add(beefBox, 1,  0, 2, 1);
		gridPane.add(porkBox, 2,  0, 2, 1);
		gridPane.add(noodlesBox, 3,  0, 2, 1);
		gridPane.add(carrotsBox, 4,  0, 2, 1);
		gridPane.add(potatoesBox, 0,  1, 1, 2);
		gridPane.add(tomatoesBox, 1,  1, 1, 2);
		gridPane.add(eggsBox, 2,  1, 1, 2);
		gridPane.add(cheeseBox, 3,  1, 1, 2);
		gridPane.add(sauceBox, 4,  1, 1, 2);
		gridPane.add(searchButton, 7 , 5, 5, 6);
		
		chickenBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				chickenBoxSelected = newval;
			}
		});
		
		beefBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				beefBoxSelected = newval;
			}
		});
		
		porkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				porkBoxSelected = newval;
			}
		});
		
		noodlesBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				noodlesBoxSelected = newval;
			}
		});
		
		carrotsBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				carrotsBoxSelected = newval;
			}
		});
		
		potatoesBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				potatoesBoxSelected = newval;
			}
		});
		
		tomatoesBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				tomatoesBoxSelected = newval;
			}
		});
		
		eggsBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				eggsBoxSelected = newval;
			}
		});
		
		cheeseBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				cheeseBoxSelected = newval;
			}
		});
		
		sauceBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov, Boolean oldval, Boolean newval) {
				sauceBoxSelected = newval;
			}
		});
		
		Scene scene = new Scene(gridPane, 450, 300);
		newStage.setScene(scene);
		newStage.show();
		
		//Create an action event handler for the search button
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	Stage stage = new Stage();
		    	// code to show the gui with the recipes
		    	
		    	try {
					ingredients.start(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	stage.show();
		    }
		});

	}

	
	public static boolean getChickenBox() {
		return chickenBoxSelected;
	}
	
	public static boolean getBeefBox() {
		return beefBoxSelected;
	}
	
	public static boolean getPorkBox() {
		return porkBoxSelected;
	}
	
	public static boolean getNoodlesBox() {
		return noodlesBoxSelected;
	}
	
	public static boolean getCarrotsBox() {
		return carrotsBoxSelected;
	}
	
	public static boolean getPotatoesBox() {
		return potatoesBoxSelected;
	}
	
	public static boolean getTomatoesBox() {
		return tomatoesBoxSelected;
	}
	
	public static boolean getEggsBox() {
		return eggsBoxSelected;
	}
	
	public static boolean getCheeseBox() {
		return cheeseBoxSelected;
	}
	
	public static boolean getSauceBox() {
		return sauceBoxSelected;
	}
	
	public static void main(String[] args) {

		Application.launch(args);

	 }
	
}
