import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    void confirmSerialFormatReturnsTrueWhenAllCharsAreLettersAndNumbers(){
        Item item = new Item(50.00, "xkcd1492chess", "All-Purpose-Flour");
        assert(item.confirmSerialFormat(item.getSerialNumber()));
    }

    @Test
    void confirmSerialFormatReturnsFalseWhenStringContainsNonNumericAlphabeticCharacter(){
        Item item = new Item(50.00, "xkcd1492chess", "All-Purpose-Flour");
        assert(!item.confirmSerialFormat("HAPPY!!TUESDAY"));
    }

    @Test
    void confirmNameLengthReturnsTrueWhenWithinGivenRange(){
        Item item = new Item(50.00, "xkcd1492chess", "All-Purpose-Flour");
        assert(item.confirmNameLength(item.getName()));
    }

    @Test
    void confirmNameLengthReturnsFalseWhenGiven1CharString(){
        Item item = new Item(50.00, "xkcd1492chess", "All-Purpose-Flour");
        assert(!item.confirmNameLength("E"));
    }

    @Test
    void confirmNameLengthReturnsFalseWhenGivenVeryLongString(){
        Item item = new Item(50.00, "xkcd1492chess", "All-Purpose-Flour");
        assert(!item.confirmNameLength("Mama, don’t whup little Buford. Mama, don’t pound on his head. Mama, don’t whup little Buford… I think you should shoot him instead. HENRY Bang! (WENDELL laughs.) HENRY Yes, folks, we only have high-class stuff on this show. And now, here’s a special treat out of Tampa — our own Trixie! (Curtain opens to reveal TRIXIE. GOMER plays the piano.) "));
    }

}