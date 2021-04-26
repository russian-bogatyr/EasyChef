import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class loginWindow extends Application {
    private TextField inputLogin = new TextField();    // text field for login
    private TextField inputPassword = new TextField();    // text field for password
    private Button btLogin = new Button("Sign in");

    
    @SuppressWarnings("resource")
	@Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Login:"), 0, 0);
        gridPane.add(inputLogin, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(inputPassword, 1, 1);
        gridPane.add(btLogin, 1, 3);
       
        gridPane.setAlignment(Pos.CENTER);
        inputLogin.setAlignment(Pos.BOTTOM_RIGHT);
        inputPassword.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane.setHalignment(btLogin, HPos.RIGHT);
 
        btLogin.setOnAction(e ->  {
        boolean Access = false;          // boolean variable for the correct input
        String login = inputLogin.getText();
        String password = inputPassword.getText();
        File file = new File("src/PersonalData");
        mainWindow mainWindow = new mainWindow(); 
        try  {
		Scanner scanner = new Scanner (file);        // scanner of file
        //mainWindow mainWindow = new mainWindow();        
                                                      // credit to  https://coderanch.com/t/694561/java/program-read-txt-file-gui
        while(scanner.hasNextLine()) {                // while scanner can read next lines it will check input and stored data in txt file 
            if (scanner.nextLine().equals(login)) {
                if (scanner.hasNextLine() && scanner.nextLine().equals(password)) {
                	Access=true;
                    break;
                }
            }
        }
        if(Access) {
        	
        	try {
				mainWindow.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
        }
        else {
        	inputPassword.clear();                // if input is incorrect, the program will clear input fields
        	inputLogin.clear();
        }
        } catch (NoSuchElementException e1) {     // if no such element in txt file
        	inputPassword.clear();                // if input is incorrect, the program will clear input fields
        	inputLogin.clear();       	
        } catch (FileNotFoundException e1) {      // if file not found
			e1.printStackTrace();
		} 
        });
    
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setTitle("EasyChef"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
        
    }
   

    public static void main(String[] args) {
        launch(args);
    }
}

