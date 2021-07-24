package ucf.assignments;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    static String data = "";

    public static Inventory readData(File file) throws FileNotFoundException {
        String name = file.getName();
        Scanner in = new Scanner(file);
        in.useDelimiter("\\Z");
        data = in.next();
        String extension = name.substring(name.lastIndexOf(".") + 1, name.length());

        Inventory inventory = new Inventory();

        if(extension.compareTo("tsv") == 0){
            inventory = readTSV();
        }else if(extension.compareTo("html") == 0){
            inventory = readHTML();
        }else if(extension.compareTo("json") == 0){
            inventory = readJson();
        }
        return inventory;
    }

    public static Inventory readTSV(){
        Scanner in = new Scanner(data);
        Inventory inventory = new Inventory();
        in.useDelimiter("\t|\n");
        while(in.hasNext()){

            Item item = new Item();
            item.setName(in.next());
            item.setSerialNumber(in.next());
            item.setValue(Double.parseDouble(in.next()));
            inventory.addItem(item);
        }
        return inventory;
    }

    public static Inventory readHTML(){
        Inventory inventory = new Inventory();
        Scanner in = new Scanner(data);
        in.useDelimiter("<td>|</td>|<td>\n</tr>\n<tr>|</body>\n</html>");
        in.next();
        //reads the main body of the file and cuts the extra characters off building the array
        while(in.hasNext()) {
            Item item = new Item();
            String name = in.nextLine();
            item.setName(name.substring(4, name.lastIndexOf('<')));
            String serial = in.nextLine();
            item.setSerialNumber(serial.substring(4, serial.lastIndexOf('<')));
            String value = in.nextLine();
            item.setValue(Double.parseDouble(value.substring(4, value.lastIndexOf('<'))));
            in.nextLine();
            in.nextLine();
            inventory.addItem(item);
        }
        return inventory;
    }


    public static Inventory readJson() throws FileNotFoundException {
        Inventory inventory = new Inventory();
        inventory = (new Gson().fromJson(data, Inventory.class));


       return inventory;
    }

    public static void saveData(File file, Inventory items) throws IOException {

        String name = file.getName();
        String extension = name.substring(name.lastIndexOf(".") + 1);
        if(extension.compareTo("tsv") == 0){
            formatTSV(items);
        }else if(extension.compareTo("html") == 0){
            formatHTML(items);
        }else if(extension.compareTo("json") == 0){
            formatJSON(items);
        }

        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.close();

    }

    public static void formatTSV(Inventory items){
        String dataTSV = "";
        for(int ticker = 0; ticker < items.getItems().size(); ticker++){
            dataTSV = dataTSV + items.getItems().get(ticker).getName() + "\t";
            dataTSV = dataTSV + items.getItems().get(ticker).getSerialNumber() + "\t";
            dataTSV = dataTSV + items.getItems().get(ticker).getValue() + "\n";
        }
        data = dataTSV;
    }

    public static void formatJSON(Inventory items){
       data = new Gson().toJson(items);
    }

    public static void formatHTML(Inventory items){
        String dataHTML = "<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  <title>This Data</title>\n</head>\n<body>\n<table style=\"width:\">\n  <tr>\n    <th>Name</th>\n    <th>Serial Number</th>\n    <th>Value</th>\n  </tr>\n";
       for(int ticker = 0; ticker < items.getItems().size(); ticker++){
           dataHTML = dataHTML + "<tr>\n<td>" +items.getItems().get(ticker).getName() + "</td>\n";
           dataHTML = dataHTML + "<td>" +items.getItems().get(ticker).getSerialNumber() + "</td>\n";
           dataHTML = dataHTML + "<td>" +items.getItems().get(ticker).getValueString() + "</td>\n</tr>\n";
       }
        dataHTML = dataHTML + "</table>\n</body>\n</html>";
        data = dataHTML;
    }
}
