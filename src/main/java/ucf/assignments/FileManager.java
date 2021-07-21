package ucf.assignments;

public class FileManager {
    String data = "";
    void saveToFile(){

    }

    void loadFromFile(){

    }

    void formatTSV(Inventory items){
        for(int ticker = 0; ticker < items.getItems().size(); ticker++){
            data = data + items.getItems().get(ticker).getName() + "\t";
            data = data + items.getItems().get(ticker).getSerialNumber() + "\t";
            data = data + items.getItems().get(ticker).getValue() + "\n";
        }
    }

    void formatJSON(Inventory items){

    }

    void formatHTML(Inventory items){

    }
}
