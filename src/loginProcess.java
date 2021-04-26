
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class loginProcess extends Application {
	boolean grantAccess = false;
	private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();
  
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * @param File f
		 */
		String userName = tfUsername.getText();
		String password = tfPassword.getText();
		File f = new File("PersonalData.txt");
		try {
		     Scanner read = new Scanner(f); 
		     int noOfLines=0; // count how many lines in the file
		     while(read.hasNextLine()){
		           noOfLines++;
		     }

		   
		    for(int i=0; i<noOfLines; i++){
		       if(read.nextLine().equals(userName)){ // if the same user name
		          i++;
		          if(read.nextLine().equals(password)){ // check password
		             grantAccess=true; // if also same, change boolean to true
		             break; // and break the for-loop
		          }
		       }
		    }
		     if(grantAccess){
		        // here we launch our app
	
		     }
		     else{
		         // return Alert message 
		     }

		} catch (FileNotFoundException e) {

		        e.printStackTrace();
		}
	}

}
