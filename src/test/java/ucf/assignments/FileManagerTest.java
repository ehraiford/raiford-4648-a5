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
        System.out.println(manager.data);
        assertEquals(0, manager.data.compareTo("<!DOCTYPE html>\n<html>\n<head>\n  <meta charset=\"UTF-8\">\n  <title>This Data</title>\n</head>\n<body>\nKitschy Mug\txkcd12344\t19.99\nTacky T-Shirt\t8sdds12\t29.99\nGaudy Snow-Globe\tsjsj102\t14.99\n\n</body>\n</html>"));
    }
}