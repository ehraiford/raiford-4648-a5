package ucf.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Item> items = new ArrayList();

    void addItem(Item input) {
        items.add(input);
    }
    void setArrayList(ArrayList<Item> input){
        items = input;
    }
    void removeItem(Item input) {
        items.remove(input);
    }

    ArrayList<Item> getItems(){
        return items;
    }

    int getItemIndexByName(String input) {
        for (int ticker = 0; ticker < items.size(); ticker++) {
            if (items.get(ticker).getName().compareTo(input) == 0) {
                return ticker;
            }
        }
        return -1;
    }

    String displayInfo(){
        String display = "Name                       Serial Number      Value\n";
        for(int ticker = 0; ticker < items.size(); ticker++){
            display = display + items.get(ticker).displayInfo();
        }
        return display;
    }
    //alternative displayInfo() that will display only items whose parameter (either serial or name) contains the given data.
    String displayInfo(String parameter, String data){
        String display = "Name                       Serial Number      Value\n";
        if(parameter.compareTo("Serial") == 0){
            for(int ticker = 0; ticker < items.size(); ticker++){
                if(items.get(ticker).getSerialNumber().contains(data)){
                    display = display + items.get(ticker).displayInfo();
                }
            }
        }else{
            for(int ticker = 0; ticker < items.size(); ticker++){
                if(items.get(ticker).getName().contains(data)){
                    display = display + items.get(ticker).displayInfo();
                }
            }
        }
        return display;
    }

    boolean confirmSerialUniqueness(String string) {
        for(int ticker = 0; ticker < items.size(); ticker++){
            if(items.get(ticker).getSerialNumber().compareTo(string) == 0){
                return false;
            }
        }
        return true;
    }

    void sortByValue() {
        for (int ticker = 0; ticker < items.size() - 1; ticker++) {
            for (int ticker2 = ticker + 1; ticker2 < items.size(); ticker2++) {
                if (items.get(ticker2).getValue() < items.get(ticker).getValue()) {
                    Collections.swap(items, ticker, ticker2);
                }
            }
        }
    }

    void sortBySerialNumber() {
        for (int ticker = 0; ticker < items.size() - 1; ticker++) {
            for (int ticker2 = ticker + 1; ticker2 < items.size(); ticker2++) {
                String cap1 = items.get(ticker).getSerialNumber().toUpperCase();
                String cap2 = items.get(ticker2).getSerialNumber().toUpperCase();
                if (cap1.compareTo(cap2) > 0) {
                    Collections.swap(items, ticker, ticker2);
                }
            }
        }
    }

    void sortByName() {
        for (int ticker = 0; ticker < items.size() - 1; ticker++) {
            for (int ticker2 = ticker + 1; ticker2 < items.size(); ticker2++) {
                String cap1 = items.get(ticker).getName().toUpperCase();
                String cap2 = items.get(ticker2).getName().toUpperCase();
                if (cap1.compareTo(cap2) > 0) {
                    Collections.swap(items, ticker, ticker2);
                }
            }
        }
    }

    int confirmOnlyOne(String parameter, String data){
        int count = 0;
        int index = -1;
        if(parameter.compareTo("Name") == 0) {
            for (int ticker = 0; ticker < items.size(); ticker++) {
                if (items.get(ticker).getName().contains(data)) {
                    index = ticker;
                    count++;
                }
            }
        }else{
            for(int ticker =  0; ticker < items.size(); ticker++){
                if(items.get(ticker).getSerialNumber().contains(data)){
                    index = ticker;
                    count++;
                }
            }
        }
        if(count == 1){
            return index;
        }else{
            return -1;
        }
    }
}
