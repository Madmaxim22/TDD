import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneBookTest {

    PhoneBook phoneBook;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void newPhoneBook() {
        phoneBook = new PhoneBook();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    public void testAdd() {
        phoneBook.add("Максим", "89267095433");
        assertTrue(phoneBook.mapName.containsKey("Максим"));
        assertTrue(phoneBook.mapName.containsValue("89267095433"));
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
        assertTrue(phoneBook.mapName.containsValue("89267095433"));
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add("Максим", "89267095433");
        String name = phoneBook.findByNumber("89267095433");
        assertEquals("Максим", name);
    }

    @Test
    public void testFindByName() {
        phoneBook.add("Максим", "89267095433");
        String number = phoneBook.findByName("Максим");
        assertEquals("89267095433", number);
    }

    @Test
    public void testPrintAllNames() {
        phoneBook.add("Максим", "89267095433");
        phoneBook.add("Альберт", "89267095434");
        phoneBook.add("Сергей", "89267095435");
        phoneBook.add("Владимир", "89267095436");

        phoneBook.printAllNames();

        assertEquals("Альберт\nВладимир\nМаксим\nСергей", outputStreamCaptor.toString().trim());
    }
}
