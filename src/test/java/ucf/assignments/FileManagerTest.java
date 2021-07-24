package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void formatTSVBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd12344", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatTSV(items);

        assertEquals(0, manager.data.compareTo("Kitschy Mug\txkcd12344\t19.99\t\nTacky T-Shirt\t8sdds12\t29.99\t\nGaudy Snow-Globe\tsjsj102\t14.99\t\n"));
    }

    @Test
    void formatHTMLBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd12344", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatHTML(items);
        assertEquals(0, manager.data.compareTo("<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  " +
                "<title>This Data</title>\n</head>\n<body>\n<table style=\"width:\">\n  <tr>\n    <th>Name</th>\n    <th>Serial Number</th>\n  " +
                "  <th>Value</th>\n  </tr>\n<tr>\n<td>Kitschy Mug</td>\n<td>xkcd12344</td>\n<td>19.99</td>\n</tr>\n<tr>\n<td>Tacky T-Shirt</td>\n" +
                "<td>8sdds12</td>\n<td>29.99</td>\n</tr>\n<tr>\n<td>Gaudy Snow-Globe</td>\n<td>sjsj102</td>\n<td>14.99</td>\n</tr>\n</table>\n</body>\n</html>"));
    }

    @Test
    void formatJSONBuildsCorrectStringFromData(){
        Item item1 = new Item(19.99, "xkcd12344", "Kitschy Mug");
        Item item2 = new Item(29.99, "8sdds12", "Tacky T-Shirt");
        Item item3 = new Item(14.99, "sjsj102", "Gaudy Snow-Globe");
        Inventory items = new Inventory();
        items.addItem(item1);
        items.addItem(item2);
        items.addItem(item3);
        FileManager manager = new FileManager();

        manager.formatJSON(items);
        assertEquals(0, manager.data.compareTo("{\"items\":[{\"value\":19.99,\"serialNumber\":\"xkcd12344\"," +
                "\"name\":\"Kitschy Mug\",\"valueString\":\"19.99\"},{\"value\":29.99,\"serialNumber\":\"8sdds12\",\"" +
                "name\":\"Tacky T-Shirt\",\"valueString\":\"29.99\"},{\"value\":14.99,\"serialNumber\":\"sjsj102\",\"" +
                "name\":\"Gaudy Snow-Globe\",\"valueString\":\"14.99\"}]}"));
    }
}