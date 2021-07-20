import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items = new ArrayList();

    void addItem(Item input){
        this.items.add(input);
    }

    void removeItem(Item input){
        items.remove(input);
    }

    boolean confirmSerialUniqueness(){
        return true;
    }

    void sortByValue(){

    }

    void sortBySerialNumber(){

    }

    void sortByName(){

    }

    void searchBySerialNumber(String input){

    }

    void searchByName(String input){

    }

}
