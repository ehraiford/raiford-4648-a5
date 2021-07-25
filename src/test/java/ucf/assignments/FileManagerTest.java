package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void formatTSVBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatTSV(items);

        assertEquals(0, manager.data.compareTo("Kitschy Mug\txkcd123445\t19.99\nTacky T-Shirt\t8sdds12111\t29.99\nGaudy Snow-Globe\tsjsj102sdf\t14.99\n"));
    }

    @Test
    void formatHTMLBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatHTML(items);
        assertEquals(0, manager.data.compareTo("<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  " +
                "<title>This Data</title>\n</head>\n<body>\n<table style=\"width:\">\n  <tr>\n    <th>Name</th>\n    <th>Serial Number</th>\n  " +
                "  <th>Value</th>\n  </tr>\n<tr>\n<td>Kitschy Mug</td>\n<td>xkcd123445</td>\n<td>19.99</td>\n</tr>\n<tr>\n<td>Tacky T-Shirt</td>\n" +
                "<td>8sdds12111</td>\n<td>29.99</td>\n</tr>\n<tr>\n<td>Gaudy Snow-Globe</td>\n<td>sjsj102sdf</td>\n<td>14.99</td>\n</tr>\n</table>\n</body>\n</html>"));
    }

    @Test
    void formatJSONBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatJSON(items);
        assertEquals(0, manager.data.compareTo("{\"items\":[{\"value\":19.99,\"serialNumber\":\"xkcd123445\"," +
                "\"name\":\"Kitschy Mug\",\"valueString\":\"19.99\"},{\"value\":29.99,\"serialNumber\":\"8sdds12111\",\"" +
                "name\":\"Tacky T-Shirt\",\"valueString\":\"29.99\"},{\"value\":14.99,\"serialNumber\":\"sjsj102sdf\",\"" +
                "name\":\"Gaudy Snow-Globe\",\"valueString\":\"14.99\"}]}"));
    }

    @Test
    void readJSONReadsDataCorrectly()  {
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory actual = new Inventory();
        actual.addItem(item1);
        actual.addItem(item2);
        actual.addItem(item3);
        FileManager manager = new FileManager();
        manager.setData("{\"items\":[{\"value\":19.99,\"serialNumber\":\"xkcd123445\"," +
                "\"name\":\"Kitschy Mug\",\"valueString\":\"19.99\"},{\"value\":29.99,\"serialNumber\":\"8sdds12111\",\"" +
                "name\":\"Tacky T-Shirt\",\"valueString\":\"29.99\"},{\"value\":14.99,\"serialNumber\":\"sjsj102sdf\",\"" +
                "name\":\"Gaudy Snow-Globe\",\"valueString\":\"14.99\"}]}");
        Inventory inventory = FileManager.readJson();

        assertEquals(0, inventory.displayInfo().compareTo(actual.displayInfo()));
    }

    @Test
    void readTSVReadsDataCorrectly(){
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory actual = new Inventory();
        actual.addItem(item1);
        actual.addItem(item2);
        actual.addItem(item3);
        FileManager manager = new FileManager();
        manager.setData("Kitschy Mug\txkcd123445\t19.99\nTacky T-Shirt\t8sdds12111\t29.99\nGaudy Snow-Globe\tsjsj102sdf\t14.99\n");
        Inventory inventory = FileManager.readTSV();

        assertEquals(0, inventory.displayInfo().compareTo(actual.displayInfo()));
    }

    @Test
    void readHTMLReadsDataCorrectly(){
        Item item1 = new Item(19.99, "xkcd123445", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12111", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102sdf", "Gaudy Snow-Globe");
        Inventory actual = new Inventory();
        actual.addItem(item1);
        actual.addItem(item2);
        actual.addItem(item3);
        FileManager manager = new FileManager();
        manager.setData("<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  " +
                "<title>This Data</title>\n</head>\n<body>\n<table style=\"width:\">\n  <tr>\n    <th>Name</th>\n    <th>Serial Number</th>\n  " +
                "  <th>Value</th>\n  </tr>\n<tr>\n<td>Kitschy Mug</td>\n<td>xkcd123445</td>\n<td>19.99</td>\n</tr>\n<tr>\n<td>Tacky T-Shirt</td>\n" +
                "<td>8sdds12111</td>\n<td>29.99</td>\n</tr>\n<tr>\n<td>Gaudy Snow-Globe</td>\n<td>sjsj102sdf</td>\n<td>14.99</td>\n</tr>\n</table>\n</body>\n</html>");
        Inventory inventory = FileManager.readHTML();

        assertEquals(0, inventory.displayInfo().compareTo(actual.displayInfo()));
    }
}