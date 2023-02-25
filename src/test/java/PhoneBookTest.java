import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneBookTest {

    PhoneBook phoneBook;
    @BeforeEach
    public void newPhoneBook() {
        phoneBook = new PhoneBook();
    }
    @Test
    public void testAdd() {
        phoneBook.add("Максим", "89267095433");
        assertTrue(phoneBook.mapPhone.containsKey("имя"));
        assertTrue(phoneBook.mapPhone.containsValue("номер"));
    }

    @Test
    public void testAddReturnSize() {
        int size = phoneBook.add("Максим", "89267095433");
        assertEquals(0, size);
    }

    @Test
    public void testAddNotDuplication() {
        phoneBook.add("Максим", "89267095433");
        phoneBook.add("Максим", "89992341565");
        assertTrue(phoneBook.mapPhone.containsValue("89267095433"));
    }
}
