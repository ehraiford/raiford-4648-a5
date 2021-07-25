package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void sortByValueSortsCorrectly(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "1919alfh18", "iPad Mini");
        Item item3 = new Item(450.00, "happy10sj2", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        inventory.sortByValue();

        assertEquals(1, inventory.getItemIndexByName("iPad Mini"));
        assertEquals(2, inventory.getItemIndexByName("Scotch Tape"));
        assertEquals(0, inventory.getItemIndexByName("Printer Ink"));
    }

    @Test
    void sortByNameSortsCorrectly(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

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
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        inventory.sortBySerialNumber();
        assertEquals(1, inventory.getItemIndexByName("Scotch Tape"));
        assertEquals(0, inventory.getItemIndexByName("Printer Ink"));
        assertEquals(2, inventory.getItemIndexByName("iPad Mini"));

    }
    @Test
    void confirmSerialUniquenessReturnsTrueIfTheSerialIsUnique(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertTrue(inventory.confirmSerialUniqueness("asdf1919alfh1890"));
    }

    @Test
    void confirmSerialUniquenessReturnsFalseIfTheSerialIsNotUnique(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertFalse(inventory.confirmSerialUniqueness("fjfjqpd91n"));
    }

    @Test
    void displayInfoGivenSerialReturnsInfoOfCorrectItems(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertEquals(0, inventory.displayInfo("Serial", "fjfjqpd91n").compareTo("Name                       Serial Number      Value\niPad Mini                  fjfjqpd91n         399.99\n"));
    }

    @Test
    void displayInfoGivenNameReturnsInfoOfCorrectItems(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertEquals(0, inventory.displayInfo("Name", "in").compareTo("Name                       Serial Number      Value\niPad Mini                  fjfjqpd91n         399.99\nPrinter Ink                00001928as         450.00\n"));
    }

    @Test
    void getItemIndexByNameReturnsProperIndexOfItem(){
        Item item1 = new Item(2, "123afjqpr1j", "Scotch Tape");
        Item item2 = new Item(399.99, "fjfjqpd91n", "iPad Mini");
        Item item3 = new Item(450.00, "00001928as", "Printer Ink");

        Inventory inventory = new Inventory();
        inventory.addItem(item2);
        inventory.addItem(item1);
        inventory.addItem(item3);

        assertEquals(2, inventory.getItemIndexByName("Printer Ink"));
    }
}