package ucf.assignments;

public class FileManager {
    String data = "";

    void saveToFile(){

    }

    void loadFromFile(){

    }

    void formatTSV(Inventory items){
        data = "";
        for(int ticker = 0; ticker < items.getItems().size(); ticker++){
            data = data + items.getItems().get(ticker).getName() + "\t";
            data = data + items.getItems().get(ticker).getSerialNumber() + "\t";
            data = data + items.getItems().get(ticker).getValue() + "\n";
        }
    }

    void formatJSON(Inventory items){

    }

    void formatHTML(Inventory items){
        String dataHTML = "<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  <title>This Data</title>\n</head>\n<body>\n";
        formatTSV(items);
        dataHTML = dataHTML + data;
        dataHTML = dataHTML + "\n</body>\n</html>";
        data = dataHTML;
    }
}
