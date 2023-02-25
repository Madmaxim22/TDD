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
        assertTrue(phoneBook.mapPhone.containsKey("Максим"));
        assertTrue(phoneBook.mapPhone.containsValue("89267095433"));
    }

    @Test
    public void testAddReturnSize() {
        int size = phoneBook.add("Максим", "89267095433");
        assertEquals(1, size);
    }

    @Test
    public void testAddNotDuplication() {
        phoneBook.add("Максим", "89267095433");
        phoneBook.add("Максим", "89992341565");
        assertTrue(phoneBook.mapPhone.containsValue("89267095433"));
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add("Максим", "89267095433");
        String name = phoneBook.findByNumber("89267095433");
        assertEquals("Максим", name);
    }
}
