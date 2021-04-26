import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ingredients extends Application{
	
public static void main(String[] args) {
		Application.launch(args);
	}

	@SuppressWarnings("resource")
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		boolean chickenBox = checkBoxes.getChickenBox();
		boolean beefBox = checkBoxes.getBeefBox();
		boolean porkBox = checkBoxes.getPorkBox();
		boolean noodlesBox = checkBoxes.getNoodlesBox();
		boolean carrotBox = checkBoxes.getCarrotsBox();
		boolean potatoesBox = checkBoxes.getPotatoesBox();
		boolean tomatoesBox = checkBoxes.getTomatoesBox();;
		boolean eggsBox = checkBoxes.getEggsBox();
		boolean cheeseBox = checkBoxes.getCheeseBox();
		boolean sauceBox = checkBoxes.getSauceBox();
		String chickenIngredient = "chicken";
		String beefIngredient = "beef";
		String porkIngredient = "pork";
		String noodlesIngredient = "noodles";
		String carrotIngredient = "carrot";
		String potatoesIngredient = "potatoes";
		String tomatoesIngredient = "tomatoes";
		String eggsIngredient = "eggs";
		String cheeseIngredient = "cheese";
		String sauceIngredient = "sauce";
		ArrayList<String> boxIngredients = new ArrayList<String>();
		
		File folder = new File("Recipes");
		File[] ingredientsFiles = folder.listFiles();
		System.out.print(ingredientsFiles);
		
		if(chickenBox == true) {
			boxIngredients.add(chickenIngredient);
		}
		if(beefBox == true) {
			boxIngredients.add(beefIngredient);
		}
		if(porkBox == true) {
			boxIngredients.add(porkIngredient);
		}
		if(noodlesBox == true) {
			boxIngredients.add(noodlesIngredient);
		}
		if(carrotBox == true) {
			boxIngredients.add(carrotIngredient);
		}
		if(potatoesBox == true) {
			boxIngredients.add(potatoesIngredient);
		}
		if(tomatoesBox == true) {
			boxIngredients.add(tomatoesIngredient);
		}
		if(eggsBox == true) {
			boxIngredients.add(eggsIngredient);
		}
		if(cheeseBox == true) {
			boxIngredients.add(cheeseIngredient);
		}
		if(sauceBox == true) {
			boxIngredients.add(sauceIngredient);
		}

		String[] str;		
		String[] ingredient = boxIngredients.toArray(new String[0]);
		

		//ingredient[0] = "spicy";
		//ingredient[1] = "chicken";
		//ingredient[2] = "pork";
		
		
		ArrayList<String> files = new ArrayList<String>();
         
		for (File f : ingredientsFiles) {
			/**
			 * @param ingredientsFiles
			 * @return files
			 */
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = null;
			while ((line = br.readLine()) != null) {
               //System.out.print(line);
				for (int i = 0; i < ingredient.length; i++){
					if (line.contains(ingredient[i])){
						files.add(f.getAbsolutePath());
						//System.out.print(files);
					}
				}
			}
		}
		
		Set<String> recipeSet = new HashSet<String>();
		recipeSet.addAll(files);
		files.clear();
		files.addAll(recipeSet);
		
		TilePane pane = new TilePane();
		for (String s : files){
			Button button = new Button(s);
			pane.getChildren().add(button);
			File file = new File(s);
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent args) {
					/**
					 * @return recipeStage
					 */
					Stage recipeStage = new Stage();
					TilePane flow = new TilePane();
					
					try(BufferedReader reader = new BufferedReader(new FileReader(s))){
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
		pane.setHgap(20);
		pane.setVgap(20);
		Scene scene = new Scene(pane, 500, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
	
