package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void sortByValueSortsCorrectly(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "1234", "iPad Mini");
        Item item3 = new Item(450.00, "123dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        inventory.sortByValue();

        assertEquals(1, inventory.getItemIndexByName("iPad Mini"));
        assertEquals(0, inventory.getItemIndexByName("Scotch Tape"));
        assertEquals(2, inventory.getItemIndexByName("Printer Ink"));
    }

    @Test
    void sortByNameSortsCorrectly(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        inventory.sortByName();

        assertEquals(0, inventory.getItemIndexByName("iPad Mini"));
        assertEquals(1, inventory.getItemIndexByName("Printer Ink"));
        assertEquals(2, inventory.getItemIndexByName("Scotch Tape"));
    }

    @Test
    void sortBySerialSortsCorrectly(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        inventory.sortBySerialNumber();
        assertEquals(0, inventory.getItemIndexByName("Scotch Tape"));
        assertEquals(1, inventory.getItemIndexByName("Printer Ink"));
        assertEquals(2, inventory.getItemIndexByName("iPad Mini"));

    }
    @Test
    void confirmSerialUniquenessReturnsTrueIfTheSerialIsUnique(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertTrue(inventory.confirmSerialUniqueness("asdf123490"));
    }

    @Test
    void confirmSerialUniquenessReturnsFalseIfTheSerialIsNotUnique(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertFalse(inventory.confirmSerialUniqueness("d234"));
    }

    @Test
    void displayInfoGivenSerialReturnsInfoOfCorrectItems(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertEquals(0, inventory.displayInfo("Serial", "d234").compareTo("Name                       Serial Number      Value\niPad Mini                  d234               399.99\n"));
    }

    @Test
    void searchByNameReturnsIndexOfCorrectItems(){
        Item item1 = new Item(2, "14567sd", "Scotch Tape");
        Item item2 = new Item(399.99, "d234", "iPad Mini");
        Item item3 = new Item(450.00, "6623dfs", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);
        assertEquals(0, inventory.displayInfo("Name", "in").compareTo("Name                       Serial Number      Value\niPad Mini                  d234               399.99\nPrinter Ink                6623dfs            450.00\n"));
    }

}