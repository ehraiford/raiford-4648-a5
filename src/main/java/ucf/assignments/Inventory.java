package ucf.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Item> items = new ArrayList();

    void addItem(Item input) {
        items.add(input);
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

    void searchBySerialNumber(String input){

    }

    void searchByName(String input){

    }
}
