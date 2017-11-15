
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class FXMain extends Application{    
    
    @Override
    public void start(Stage primaryStage) throws Exception {       
        
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Guess Game");
        alert.setHeaderText("Welcome!");
        alert.setContentText("Click OK to go!");
        alert.showAndWait();
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter number");
        dialog.setHeaderText("Guess a number between 1-100");
        dialog.setContentText("Number: ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            // What to do after input
            System.out.println("The user entered " + result.get());
        }        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

