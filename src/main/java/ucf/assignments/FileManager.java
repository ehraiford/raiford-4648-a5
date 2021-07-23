package ucf.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
    static String data = "";

    public static Inventory readData(File file) throws FileNotFoundException {
        String name = file.getName();
        Scanner in = new Scanner(file);
        String extension = name.substring(name.lastIndexOf(".") + 1, name.length());

        Inventory inventory = new Inventory();

        if(extension.compareTo("tsv") == 0){
            inventory = readTSV(file, in);
        }else if(extension.compareTo("html") == 0){

        }else if(extension.compareTo("json") == 0){

        }
        return inventory;
    }

    public static void saveData(File file, Inventory items) throws FileNotFoundException {

        String name = file.getName();
        Scanner in = new Scanner(file);
        String extension = name.substring(name.lastIndexOf(".") + 1, name.length());
        if(extension.compareTo("tsv") == 0){
          formatTSV(items);
        }else if(extension.compareTo("html") == 0){

        }else if(extension.compareTo("json") == 0){

        }

    }

    public static void formatTSV(Inventory items){
        String dataTSV = "";
        for(int ticker = 0; ticker < items.getItems().size(); ticker++){
            dataTSV = dataTSV + items.getItems().get(ticker).getName() + "\t";
            dataTSV = dataTSV + items.getItems().get(ticker).getSerialNumber() + "\t";
            dataTSV = dataTSV + items.getItems().get(ticker).getValue() + "\t\n";
        }
        data = dataTSV;
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

    public static Inventory readTSV(File tsv, Scanner in){
        Inventory invent = new Inventory();
        in.useDelimiter("\t");
        while(in.hasNext()){

            Item item = new Item();
            item.setName(in.next());
            item.setSerialNumber(in.next());
            item.setValue(Double.parseDouble(in.next()));
            invent.addItem(item);
        }
        return invent;
    }
}
