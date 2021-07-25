package ucf.assignments;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void confirmSerialFormatReturnsTrueWhenAllCharsAreLettersAndNumbers(){
        Item item = new Item(50.00, "101029dfjq", "All-Purpose-Flour");
        assert(item.confirmSerialFormat(item.getSerialNumber()));
    }

    @Test
    void confirmSerialFormatReturnsFalseWhenStringContainsNonNumericAlphabeticCharacter(){
        Item item = new Item();
        assert(!item.confirmSerialFormat("HAPPY!!TUESDAY"));
    }

    @Test
    void confirmSerialFormatReturnsFalseWhenStringIsNotTenCharacters(){
        Item item = new Item();
        assert(!item.confirmSerialFormat("ThisIsNotTenCharacters"));
    }

    @Test
    void confirmNameLengthReturnsTrueWhenWithinGivenRange(){
        Item item = new Item(123, "191918273j", "Coffee Mug");
        assert(item.confirmNameLength(item.getName()));
    }

    @Test
    void confirmNameLengthReturnsFalseWhenGiven1CharString(){
        Item item = new Item();
        assert(!item.confirmNameLength("E"));
    }

    @Test
    void confirmNameLengthReturnsFalseWhenGivenVeryLongString(){
        Item item = new Item();
        assert(!item.confirmNameLength("Mama, don’t whup little Buford. Mama, don’t pound on his head. Mama," +
                " don’t whup little Buford… I think you should shoot him instead. HENRY Bang! (WENDELL laughs.) HENRY" +
                " Yes, folks, we only have high-class stuff on this show. And now, here’s a special treat out of Tampa " +
                "— our own Trixie! (Curtain opens to reveal TRIXIE. GOMER plays the piano.) "));
    }

    @Test
    void serialNumberIsEditable(){
        Item item = new Item(55, "SHDJK10294", "Burrito Bowl");
        item.setSerialNumber("NewSerial!");
        assertEquals(0, item.getSerialNumber().compareTo("NewSerial!"));
    }

    @Test
    void valueIsEditable(){
        Item item = new Item(55, "SHDJK10294", "Burrito Bowl");
        item.setValue(500);
        assertEquals(500, item.getValue());
    }

    @Test
    void nameIsEditable(){
        Item item = new Item(55, "SHDJK10294", "Burrito Bowl");
        item.setName("Burrito");
        assertEquals(0, item.getName().compareTo("Burrito"));
    }
}