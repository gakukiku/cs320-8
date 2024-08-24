//cs320
//projectdone
//GakuKikuchi

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("67890", "Alice", "Smith", "0987654321", "456 Elm St");
        assertEquals("67890", contact.getContactId());
        assertEquals("Alice", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Alice", "Smith", "0987654321", "456 Elm St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Alice", "Smith", "0987654321", "456 Elm St");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("67890", "Alice", "Smith", "09876", "456 Elm St");
        });
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("67890", "Alice", "Smith", "0987654321", "This address is way too long for the specified limit");
        });
    }
}
