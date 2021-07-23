package ucf.assignments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private double value;
    private String serialNumber;
    private String name;

    public Item() {
        //empty constructor
    }

    public Item(double value, String serialNumber, String name) {
            this.value = value;
            this.serialNumber = serialNumber;
            this.name = name;
    }    public boolean confirmSerialFormat(String input){
        for(int ticker = 0; ticker < input.length(); ticker ++){
            if(!Character.isAlphabetic(input.charAt(ticker)) && !Character.isDigit(input.charAt(ticker))){
                return false;
            }
        }
        return true;
    }

    public boolean confirmNameLength(String input){
        return input.length() > 1 && input.length() < 257;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String calcSpace(String input, int available) {
        String spaces = "";
        if (input.length() < available) {
            for (int ticker = input.length(); ticker < available; ticker++) {
                spaces = spaces + " ";
            }
            return spaces;
        }
        return " ";
    }


    public String displayInfo(){
        String valueString = String.format("%.2f", this.value);
        String space1 = calcSpace(this.name, 27);
        String space2 = calcSpace(this.serialNumber, 19);
        return name + space1+ serialNumber + space2 + valueString +"\n";
    }
}
