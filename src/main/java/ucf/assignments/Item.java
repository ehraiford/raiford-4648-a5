package ucf.assignments;

public class Item {
    private double value;
    private String serialNumber;
    private String name;

    public boolean confirmSerialFormat(String input){
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

    public Item(double value, String serialNumber, String name) {
        if (confirmSerialFormat(serialNumber) && confirmNameLength(name)) {
            this.value = value;
            this.serialNumber = serialNumber;
            this.name = name;
        }
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
}
