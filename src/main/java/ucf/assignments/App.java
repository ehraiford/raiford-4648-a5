package ucf.assignments;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class App extends Application {
    @FXML TableView tableContents = new TableView();
    @FXML TableColumn nameColumn = new TableColumn();
    @FXML TableColumn serialColumn = new TableColumn();
    @FXML TableColumn valueColumn = new TableColumn();
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("InventoryManager.fxml"));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}