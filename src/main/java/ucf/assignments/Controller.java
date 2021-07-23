package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;

public class Controller {

    @FXML TextField fileDirectory = new TextField();
    @FXML TextField fileName = new TextField();
    @FXML TextField addValue = new TextField();
    @FXML TextField editSerial = new TextField();
    @FXML TextField searchInfo = new TextField();
    @FXML TextField editName = new TextField();
    @FXML TextField resultField = new TextField();
    @FXML TextField editValue = new TextField();
    @FXML TextField addSerial = new TextField();
    @FXML TextField addName = new TextField();
    @FXML TextArea textArea = new TextArea();
    private Inventory inventory = new Inventory();
    private int editIndex;
    private FileChooser fileChooser = new FileChooser();

    public void addItem(ActionEvent actionEvent) {
        Item item = new Item();
        //if statement along with the try catch ensure that value, serial number, and name all meet the requirements before the program makes an item with them
        try {
            double value = Double.parseDouble(addValue.getText());
            if (item.confirmNameLength(addName.getText()) && item.confirmSerialFormat(addSerial.getText()) && inventory.confirmSerialUniqueness(addSerial.getText())) {
                item.setName(addName.getText());
                item.setValue(value);
                item.setSerialNumber(addSerial.getText());
                resultField.setText(item.getName() +" was added to your inventory.");
                inventory.addItem(item);
                textArea.setText(inventory.displayInfo());
                addName.setText("");
                addValue.setText("");
                addSerial.setText("");
                return;
            }
        }catch(Exception e){
        }
        resultField.setText("Could not add Item. Confirm Item meets requirements within ReadMe.");
    }

    public void searchByName(ActionEvent actionEvent) {
        if(searchInfo.getText().length() > 0) {
            textArea.setText(inventory.displayInfo("Name", searchInfo.getText()));
            editIndex = inventory.confirmOnlyOne("Name", searchInfo.getText());
            resultField.setText("Displaying Items whose name contains input.");
            System.out.println(editIndex);

            if (editIndex != -1) {
                editName.setText(inventory.getItems().get(editIndex).getName());
                editSerial.setText(inventory.getItems().get(editIndex).getSerialNumber());
                editValue.setText(inventory.getItems().get(editIndex).getValueString());
            }
        } else{
            resultField.setText("Please enter your search into the Search Field.");
        }
    }

    public void searchBySerialNumber(ActionEvent actionEvent) {
        if (searchInfo.getText().length() > 0) {
            textArea.setText(inventory.displayInfo("Serial", searchInfo.getText()));
            editIndex = inventory.confirmOnlyOne("Serial", searchInfo.getText());
            resultField.setText("Displaying Items whose serial number contains input.");

            if (editIndex != -1) {
                editName.setText(inventory.getItems().get(editIndex).getName());
                editSerial.setText(inventory.getItems().get(editIndex).getSerialNumber());
                editValue.setText(inventory.getItems().get(editIndex).getValueString());
            }
        } else {
            resultField.setText("Please enter your search into the Search Field.");
        }
    }

    public void editItem(ActionEvent actionEvent) {
        if(editIndex != -1){

        }else{
            resultField.setText("Narrow your search to only yield one answer.");
        }
    }

    public void deleteItem(ActionEvent actionEvent) {
        if(editIndex != -1){

        }else{
            resultField.setText("Narrow your search to only yield one answer.");
        }
    }

    public void sortByName(ActionEvent actionEvent) {
        resultField.setText("Sorted by Name.");
        inventory.sortByName();
        textArea.setText(inventory.displayInfo());
    }

    public void sortBySerial(ActionEvent actionEvent) {
        resultField.setText("Sorted by Serial Number.");
        inventory.sortBySerialNumber();
        textArea.setText(inventory.displayInfo());
    }

    public void saveTSV(ActionEvent actionEvent) throws Exception {
        fileChooser.setTitle("Save File");
        FileChooser.ExtensionFilter tsv = new FileChooser.ExtensionFilter("TSV (.tsv)", "*.tsv");
        FileChooser.ExtensionFilter html = new FileChooser.ExtensionFilter("HTML (.html)", "*.html");
        FileChooser.ExtensionFilter json = new FileChooser.ExtensionFilter("JSON (.json)", "*.json");
        fileChooser.getExtensionFilters().add(tsv);
        fileChooser.getExtensionFilters().add(html);
        fileChooser.getExtensionFilters().add(json);
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            if(!file.exists()){
                file.createNewFile();
            }
            FileManager.saveData(file, inventory);
        }
    }

    public void saveJSON(ActionEvent actionEvent) {
    }

    public void saveHTML(ActionEvent actionEvent) {
    }

    public void loadTSV(ActionEvent actionEvent) throws FileNotFoundException {
        fileChooser.setTitle("Load File");
        File selected = fileChooser.showOpenDialog(null);
        if (selected != null) {
            resultField.setText("Opened " + selected.getName() + ".");
            inventory = FileManager.readData(selected);
            textArea.setText(inventory.displayInfo());
        }else{
            resultField.setText(("Could not open a file."));
        }
    }

    public void loadHTML(ActionEvent actionEvent) {
    }

    public void loadJSON(ActionEvent actionEvent) {
    }
}
