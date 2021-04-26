/*
 * EasyChef search bar deliverable
 * Author: Joshua Palmer
 * Reference and help to this code is thanks to user Sedrick on StackOverflow 
 * Original concept/model can be found here: 
 * https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx 
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application
{

   

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("EasyChef");
        stage.setWidth(750);
        stage.setHeight(250);

        final Label label = new Label("Search");
        label.setFont(new Font("Arial", 20));

        /**
         * code for creating the choicebox and
         * text field for recipe searching
         */
        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll("Recipe", "Time", "Rating");
        choiceBox.setValue("Recipe");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.setOnKeyReleased(keyEvent ->
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
        {//reset table and textfield when new choice is selected
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
        vbox.getChildren().addAll(label, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    
}